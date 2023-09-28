package com.investigation.java8.stream;

import java.util.ArrayList;
import static java.util.Comparator.comparingInt;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;

public class App {
    private List<String> names;
    private List<String> numbers;

    List<BlogPost> posts;

    public App() {
        names = new ArrayList<>();
        names.add("Peter");
        names.add("Mery");
        names.add("Louise");
        names.add("Sandy");
        names.add("Marie");

        numbers = new ArrayList<>();
        numbers.add("5");
        numbers.add("10");
        numbers.add("2");
        numbers.add("23");
        numbers.add("50");

        posts = new ArrayList<>();
        posts.add(new BlogPost("AWS", "Erick", BlogPostType.NEWS, 50));
        posts.add(new BlogPost("Azure", "Mark", BlogPostType.REVIEW, 30));
        posts.add(new BlogPost("GCP", "Lisa", BlogPostType.GUIDE, 40));
        posts.add(new BlogPost("Java", "Charles", BlogPostType.NEWS, 20));
        posts.add(new BlogPost("Python", "Karin", BlogPostType.GUIDE, 64));
        posts.add(new BlogPost("JavaScript", "Louise", BlogPostType.NEWS, 10));
        posts.add(new BlogPost("DevOps", "Yen", BlogPostType.REVIEW, 23));
    }

    private void filter() {
        names.stream().filter(name -> name.startsWith("M")).forEach(System.out::println);
    }

    private void transform() {
        names.stream().map(String::toUpperCase).forEach(System.out::println);
        numbers.stream().map(number -> Integer.parseInt(number) + 1).forEach(System.out::println);
    }

    private void sorted() {
        //names.stream().sorted().forEach(System.out::println);
        //names.stream().sorted(String::compareTo).forEach(System.out::println);
        names.stream().sorted((x, y) -> y.compareTo(x)).forEach(System.out::println);
    }

    private void limit() {
        names.stream().limit(3).forEach(System.out::println);
    }

    private void count() {
        long count = names.stream().count();
        System.out.println("count: " + count);
    }

    private void grouping() {
        Map<BlogPostType, List<BlogPost>> postsPerType = posts.stream()
                .collect(groupingBy(BlogPost::getType));
        System.out.println(postsPerType);
    }

    private void sumGrouping() {
        Map<BlogPostType, Integer> likesPerType = posts.stream()
                .collect(groupingBy(BlogPost::getType, summingInt(BlogPost::getLikes)));
        System.out.println("Likes per type: " + likesPerType);
    }

    private void averageGrouping() {
        Map<BlogPostType, Double> averagePerType = posts.stream()
                .collect(groupingBy(BlogPost::getType, averagingInt(BlogPost::getLikes)));
        System.out.println("Average per type: " + averagePerType);
    }

    private void maxGrouping() {
        Map<BlogPostType, Optional<BlogPost>> maxLikesPerPostType = posts.stream()
                .collect(groupingBy(BlogPost::getType,
                        maxBy(comparingInt(BlogPost::getLikes))));
        System.out.println("Max per type: " + maxLikesPerPostType);
    }

    private void summaryGrouping() {
        Map<BlogPostType, IntSummaryStatistics> likeStatisticsPerType = posts.stream()
                .collect(groupingBy(BlogPost::getType,
                        summarizingInt(BlogPost::getLikes)));
        System.out.println("Summary per type: " + likeStatisticsPerType);
    }

    private void range() {
        IntStream stream = IntStream.range(6, 10);
        stream.forEach(System.out::println);
    }

    public static void main(String[] args) {
        App app = new App();
        //app.filter();
        //app.sorted();
        //app.transform();
        //app.limit();
        //app.count();
        //app.grouping();
        //app.sumGrouping();
        //app.averageGrouping();
        //app.maxGrouping();
        //app.summaryGrouping();
        app.range();
    }
}