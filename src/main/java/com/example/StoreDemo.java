package com.example;

import java.util.List;

public class StoreDemo {
    public static void main(String[] args) {
        Store store = new Store();

        FlowerSpecs roseSpecs = new FlowerSpecs(FlowerColor.RED,
                FlowerType.ROSE);
        FlowerSpecs tulipSpecs = new FlowerSpecs(FlowerColor.BLUE,
                FlowerType.TULIP);
        FlowerSpecs chamomileSpecs = new FlowerSpecs(FlowerColor.GREEN,
                FlowerType.CHAMOMILE);

        Flower redRose = new Flower(10.5, 25.0, roseSpecs);
        Flower blueTulip = new Flower(8.0, 15.0, tulipSpecs);
        Flower greenChamomile = new Flower(5.5, 10.0, chamomileSpecs);

        FlowerPack rosePack = new FlowerPack(redRose, 5);
        FlowerPack tulipPack = new FlowerPack(blueTulip, 3);
        FlowerPack chamomilePack = new FlowerPack(greenChamomile, 8);

        FlowerBucket bucketOne = new FlowerBucket();
        bucketOne.addFlowerPack(rosePack);
        bucketOne.addFlowerPack(tulipPack);

        FlowerBucket bucketTwo = new FlowerBucket();
        bucketTwo.addFlowerPack(chamomilePack);

        FlowerBucket bucketThree = new FlowerBucket();
        bucketThree.addFlowerPack(rosePack);

        store.addFlowerBucket(bucketOne);
        store.addFlowerBucket(bucketTwo);
        store.addFlowerBucket(bucketThree);

        System.out.println("=== Store Demo ===");
        System.out.println("Total buckets in store: "
                + store.getBucketCount());
        System.out.println("Total inventory value: $"
                + store.getTotalInventoryValue());
        System.out.println("Store info: "
                + store.toString());

        System.out.println("\n=== Searching for roses ===");
        List<FlowerBucket> roseBuckets = store.search(roseSpecs);
        System.out.println("Found " + roseBuckets.size()
                + " buckets with roses");

        System.out.println("\n=== Searching for tulips ===");
        List<FlowerBucket> tulipBuckets = store.search(tulipSpecs);
        System.out.println("Found " + tulipBuckets.size()
                + " buckets with tulips");

        System.out.println("\n=== Removing a bucket ===");
        boolean removed = store.removeFlowerBucket(bucketTwo);
        System.out.println("Bucket removed: " + removed);
        System.out.println("Remaining buckets: " + store.getBucketCount());
    }
}