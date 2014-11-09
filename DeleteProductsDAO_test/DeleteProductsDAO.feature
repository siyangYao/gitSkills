Feature: Delete products test

Scenario: Test saveOrUpdate() 
    Given the productId is 9cbd0f68-e4f4-4241-ad0b-dae816b2a5e1
    Given the productType is movie
    Given the productKey is movie_key
    When it is passed to saveOrUpdate
    Then the entity should be founded by ProductKey

Scenario: Test productType can be founded by productKey
    Given the productId is 9cbd0f68-e4f4-4241-ad0b-dae816b2a5e1
    Given the productType is movie
    Given the productKey is movie_key
    When it is passed to findProductTypeByProductKey
    Then the entity type should be founded by ProductKey

Scenario: Delete product
    Given the productId is 9cbd0f68-e4f4-4241-ad0b-dae816b2a5e1
    Given the productType is movie
    Given the productKey is movie_key
    When it is passed to deleteByKey
    Then the entity should be deleted