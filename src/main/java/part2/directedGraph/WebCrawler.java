package part2.directedGraph;

import utils.In;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dinesh on 4/2/2016.
 */
public class WebCrawler {
    private Queue<String> queue;
    private Set<String> marked;
    private String root;
    private Map<String, String> contains;

    public WebCrawler(String url, int depth) {

        this.root = url;
        queue = new ArrayDeque<>();
        marked = new HashSet<>();
        contains = new HashMap<>();
        queue.add(root);
        marked.add(root);
        search(root, depth);
    }

    private void search(String root, int depth) {
        int num = 0;
        while (!queue.isEmpty()) {
            String site = queue.poll();
            try {


                In in = new In(site);
                String input = in.readAll();
                contains.put(site, input);
                String regexp = "http://(\\w+\\.)*(\\w+)";
                Pattern pattern = Pattern.compile(regexp);
                Matcher matcher = pattern.matcher(input);
                while (matcher.find() && num <= depth) {
                    String w = matcher.group();
                    if (!marked.contains(w)) {
                        queue.add(w);
                        marked.add(w);
                    }

                }
                num++; // After the loops

                System.out.println("Depth =" + num + ", queue Depth: " + queue.size());
            } catch (Exception e) {
                System.err.println(e.getStackTrace());
            }
        }
    }

    public Map<String, String> getContains() {
        return contains;
    }

    public static void main(String[] args) {
        WebCrawler webCrawler = new WebCrawler("http://www.princeton.edu", 3);
        Map<String, String> map = webCrawler.getContains();
        System.out.println("map size:" + map.size());

    }
}
