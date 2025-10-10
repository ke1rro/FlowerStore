package com.example;

public class StoreTest {

    public static void main(String[] args) {
        System.out.println("=== Running Store Tests ===");

        testStoreCreation();
        testAddFlowerBucket();
        testSearchFunctionality();
        testPriceCalculations();
        testRemoveFlowerBucket();

        System.out.println("=== All Tests Completed Successfully! ===");
    }

    private static void testStoreCreation() {
        System.out.println("Testing store creation...");
        Store store = new Store();
        assert store.getBucketCount() == 0 : "New store should be empty";
        assert store.isEmpty() : "New store should report as empty";
        assert store.getTotalInventoryValue() == 0.0 : "Empty store should have zero value";
        System.out.println("✓ Store creation test passed");
    }

    private static void testAddFlowerBucket() {
        System.out.println("Testing adding flower buckets...");
        Store store = new Store();
        FlowerSpecs roseSpecs = new FlowerSpecs(FlowerColor.RED, FlowerType.ROSE);
        Flower rose = new Flower(10.0, 25.0, roseSpecs);
        FlowerPack rosePack = new FlowerPack(rose, 2);
        FlowerBucket bucket = new FlowerBucket();
        bucket.addFlowerPack(rosePack);

        store.addFlowerBucket(bucket);

        assert store.getBucketCount() == 1 : "Store should have one bucket";
        assert !store.isEmpty() : "Store should not be empty";
        assert store.getTotalInventoryValue() == 50.0 : "Store value should be 50.0";

        store.addFlowerBucket(null);
        assert store.getBucketCount() == 1 : "Should not add null bucket";

        System.out.println("Add flower bucket test passed");
    }

    private static void testSearchFunctionality() {
        System.out.println("Testing search functionality...");
        Store store = new Store();

        FlowerSpecs roseSpecs = new FlowerSpecs(FlowerColor.RED, FlowerType.ROSE);
        FlowerSpecs tulipSpecs = new FlowerSpecs(FlowerColor.BLUE, FlowerType.TULIP);

        Flower rose = new Flower(10.0, 25.0, roseSpecs);
        Flower tulip = new Flower(8.0, 15.0, tulipSpecs);

        FlowerBucket bucket1 = new FlowerBucket();
        bucket1.addFlowerPack(new FlowerPack(rose, 2));

        FlowerBucket bucket2 = new FlowerBucket();
        bucket2.addFlowerPack(new FlowerPack(tulip, 3));

        FlowerBucket bucket3 = new FlowerBucket();
        bucket3.addFlowerPack(new FlowerPack(rose, 1));

        store.addFlowerBucket(bucket1);
        store.addFlowerBucket(bucket2);
        store.addFlowerBucket(bucket3);

        var roseBuckets = store.search(roseSpecs);
        assert roseBuckets.size() == 2 : "Should find 2 buckets with roses";

        var tulipBuckets = store.search(tulipSpecs);
        assert tulipBuckets.size() == 1 : "Should find 1 bucket with tulips";

        FlowerSpecs chamomileSpecs = new FlowerSpecs(FlowerColor.GREEN, FlowerType.CHAMOMILE);
        var chamomileBuckets = store.search(chamomileSpecs);
        assert chamomileBuckets.size() == 0 : "Should find 0 buckets with chamomile";

        System.out.println("Search functionality test passed");
    }

    private static void testPriceCalculations() {
        System.out.println("Testing price calculations...");
        Store store = new Store();

        FlowerSpecs roseSpecs = new FlowerSpecs(FlowerColor.RED, FlowerType.ROSE);
        Flower rose = new Flower(10.0, 25.0, roseSpecs);

        FlowerBucket bucket1 = new FlowerBucket();
        bucket1.addFlowerPack(new FlowerPack(rose, 2)); // 50.0

        FlowerBucket bucket2 = new FlowerBucket();
        bucket2.addFlowerPack(new FlowerPack(rose, 4)); // 100.0

        store.addFlowerBucket(bucket1);
        store.addFlowerBucket(bucket2);

        assert store.getTotalInventoryValue() == 150.0 : "Total value should be 150.0";

        System.out.println("Price calculations test passed");
    }

    private static void testRemoveFlowerBucket() {
        System.out.println("Testing remove flower bucket...");
        Store store = new Store();

        FlowerSpecs roseSpecs = new FlowerSpecs(FlowerColor.RED, FlowerType.ROSE);
        Flower rose = new Flower(10.0, 25.0, roseSpecs);
        FlowerBucket bucket = new FlowerBucket();
        bucket.addFlowerPack(new FlowerPack(rose, 2));

        store.addFlowerBucket(bucket);
        assert store.getBucketCount() == 1 : "Should have 1 bucket";

        boolean removed = store.removeFlowerBucket(bucket);
        assert removed : "Should successfully remove bucket";
        assert store.getBucketCount() == 0 : "Should have 0 buckets after removal";
        assert store.isEmpty() : "Store should be empty after removal";

        boolean removedAgain = store.removeFlowerBucket(bucket);
        assert !removedAgain : "Should not remove non-existent bucket";

        System.out.println("Remove flower bucket test passed");
    }

}