import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.fuhu.bluemorpho.dao.DeleteProductsDAO;
import com.fuhu.bluemorpho.proto.productTypes.ProductTypes.ProductType.Type;
import com.fuhu.bluemorpho.proto.products.ProductsProto;
import com.fuhu.bluemorpho.proto.products.ProductsProto.ProductsWithType;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.*;

@ContextConfiguration(locations = { "classpath:cucumber.xml" })
public class DeleteProductsDAOStepdefs{
    @Autowired
    private DeleteProductsDAO deleteProductsDAO;
    private ProductType.Type entity;
    private String productId, productKey;
    private Type productType;

    @Given("^the (.+) is (.+)$")
    public void setValue(String key, String value){
        if(key.equals("productId")) this.productId = value;
        else if(key.equals("productKey")) this.productKey = value;
        else if(key.equals("productType")) this.productType = Type.movie;
    }

    @When("^it is passed to (.+)$")
    public void pass_to_function(String function){
        if(function.equals("saveOrUpdate")) this.saveOrUpdate();
        else if(function.equals("findProductTypeByProductKey")) entity=findProductTypeByProductKey(this.productKey);
        else if(function.equals("deleteByKey")) this.deleteByKey(this.productKey);
    }

    public void saveOrUpdate(){
        ProductsWithType.Builder entity=ProductsWithType.newBuilder();
        entity.setProductId(this.productId)
              .setProductKey(this.productKey)
              .setProductType(this.productType);
        deleteProductsDAO.saveOrUpdate(entity);
    }

    public ProductType.Type findProductTypeByProductKey(String productKey){
        return deleteProductsDAO.findProductTypeByProductKey(productKey);
    }

    public void deleteByKey(String productKey){
        List<ProductsWithType.Builder> list=deleteProductsDAO.findProductByProductKey(productKey);
        deleteProductsDAO.deleteByKey(list.get(0)); 
    }

    @Then("^the entity should be founded by productKey")
    public void findByProductKey(){
        List<ProductsWithType.Builder> list=deleteProductsDAO.findProductByProductKey(this.productKey);
        assertEquals(list.get(0).getProductId(), this.productId);
        assertEquals(list.get(0).getProductKey(), this.productKey);
        assertEquals(list.get(0).getProductType(), this.productTpye);
    }

    @Then("^the entity type should be founded by productKey")
    public void findTypeByProductKey(){
        assertEquals(entity,this.productType);
    }
    @Then("^the entity should be deleted")
    public void deleteProductByKey(){
        List<ProductsWithType.Builder> list=deleteProductsDAO.findProductByProductKey(this.productKey);
        assertTrue(list.size() == 0);
    }
}