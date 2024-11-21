import java.util.ArrayList;

public class SortedList {
    private ArrayList<String> list;

    public SortedList() {
        list = new ArrayList<>();
    }

    // Add a string in sorted order using binary search
    public void add(String element) {
        int position = binarySearch(element);
        list.add(position, element);
    }

    // Binary search to find the correct position to insert the element
    private int binarySearch(String element) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (list.get(mid).compareTo(element) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low; // Position where the element should be inserted
    }

    // Search for an element or return its position if not found
    public String search(String element) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (list.get(mid).equals(element)) {
                return element + " is at position " + mid;
            } else if (list.get(mid).compareTo(element) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return "String not found; Would be at position " + low;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}