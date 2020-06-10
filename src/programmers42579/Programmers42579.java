package programmers42579;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Programmers42579 {
    public static void main(String[] args) {
//        String[] genres = {
//                "classic",
//                "pop",
//                "classic",
//                "classic",
//                "pop",
//                "pop",
//                "pop",
//                "pop",
//                "pop",
//                "pop",
//                "pop",
//                "pop"
//        };
//        int[] plays = {800, 600, 500, 800, 2500, 0, 1, 2, 10000, 500, 500, 600, 700};
//
        String[] genres = {"a", "b", "c", "d", "e", "f"};
        int[] plays = {1, 2, 3, 4, 5, 6};

        int[] result = solve(genres, plays);

        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static int[] solve(String[] genres, int[] plays) {
        int size = genres.length;

        List<Integer> result = new ArrayList<>();
        Map<String, List<Music>> songs = new HashMap<>();
        Map<String, Integer> playOfSome = new HashMap<>();

        for(int i = 0; i < size; i++) {
            Music music = new Music(i, genres[i], plays[i]);
            List<Music> list = songs.get(genres[i]);
            if(list == null) list = new LinkedList<Music>();

            list.add(music);
            songs.put(genres[i], list);
        }

        for(String genere : songs.keySet()) {
            List<Music> list = songs.get(genere);
            int countOfPlay = list.stream().mapToInt(Music::getPlay).sum();
            playOfSome.put(genere, countOfPlay);
            Collections.sort(list, Collections.reverseOrder());
        }

        Object[] a = playOfSome.entrySet().toArray();
        Arrays.sort(a, (Comparator) (o1, o2) -> ((Map.Entry<String, Integer>) o2).getValue()
                .compareTo(((Map.Entry<String, Integer>) o1).getValue()));

        for(Object e : a) {
            String genere = ((Map.Entry<String, Integer>) e).getKey();
            List<Music> list = songs.get(genere);
            if(list.size() < 2) {
                result.add(list.get(0).getId());
                continue;
            }

            for(int j = 0; j < 2; j++) {
                result.add(list.get(j).getId());
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    public static class Music implements Comparable<Music>{
        int id;
        String genere;
        int play;

        public Music(int id, String genere, int play) {
            this.id = id;
            this.genere = genere;
            this.play = play;
        }

        public int getPlay() {return play;}
        public int getId() {return id;}

        @Override
        public int compareTo(Music otherMusic) {
            if(this.play < otherMusic.getPlay()) return -1;
            else if(this.play > otherMusic.getPlay()) return 1;
            else if(this.play == otherMusic.getPlay()) {
                if(this.id < otherMusic.getId()) return 1;
                else if(this.id > otherMusic.getId()) return -1;
                else return 0;
            }
            return 0;
        }
    }
}
