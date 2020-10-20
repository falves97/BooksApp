package utilities;

import entities.Media;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MediaSearch {
    public static Media byId(List<Media> medias, Long key) {
        Media media = new Media();
        media.setId(key);
        medias = medias.stream().
                sorted(Comparator.comparing(Media::getId)).
                collect(Collectors.toList());

        int i = Collections.binarySearch(medias, media, (x, y) -> Long.compare(x.getId(), y.getId()));

        if(i > 0)
            return medias.get(i);
        else
            return null;
    }
}
