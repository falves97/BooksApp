package comparators;

import entities.Media;

import java.util.Comparator;

public class IdComparator implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        return (int) (o1.getId() - o2.getId());
    }
}
