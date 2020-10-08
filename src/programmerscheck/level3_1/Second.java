package programmerscheck.level3_1;

import java.util.*;

public class Second {
    public static void main(String[] args) {
        String[] generes = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        int[] solution = solution(generes, plays);
        for(int i = 0, length = solution.length; i < length; i++) {
            System.out.println(solution[i]);
        }
    }

    public static int[] solution(String[] genres, int[] plays) {
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
            int countOfPlay = list.stream().mapToInt(music -> music.plays).sum();
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
                result.add(list.get(0).id);
                continue;
            }

            for(int j = 0; j < 2; j++) {
                result.add(list.get(j).id);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    static class Music implements Comparable<Music>{
        int id;
        String genere;
        int plays;

        public Music(int id, String genere, int plays) {
            this.id = id;
            this.genere = genere;
            this.plays = plays;
        }

        @Override
        public int compareTo(Music o) {
            if(this.plays < o.plays) return -1;
            else if(this.plays > o.plays) return 1;
            else if(this.plays == o.plays) {
                if(this.id < o.id) return 1;
                else if(this.id > o.id) return -1;
                else return 0;
            }
            return 0;
        }
    }
}
