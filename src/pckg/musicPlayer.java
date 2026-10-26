
package pckg;

import java.util.*;

public class musicPlayer {


    private List<String> playList = new LinkedList<>();
    private HashMap<Integer, String> library = new HashMap<>();
    private Deque<String> upNext = new ArrayDeque<>();
    private Deque<String> history = new ArrayDeque<>();
    private HashMap<Integer, Integer> playCounts = new HashMap<>();

    private String current = null;

    public boolean addSong(int id, String title, String artist) {
        if (library.containsKey(id)) {
            return false;
        }

        library.put(id, title);
        playList.add(title);
        playCounts.put(id, 0);

        return true;
    }

    public String findSong(int id) {
        return library.get(id);
    }

    public List<String> showPlayList() {
        return new LinkedList<>(playList);
    }

    public List<String> showPlaylist() {
        return showPlayList();
    }

    private void startSong(String song) {
        current = song;

        for (int id : library.keySet()) {
            if (library.get(id).equals(song)) {
                playCounts.put(id, playCounts.getOrDefault(id, 0) + 1);
                return;
            }
        }
    }

    public String play(int id) {
        if (!library.containsKey(id)) {
            return null;
        }

        String song = library.get(id);

        if (current != null) {
            history.push(current);
        }

        startSong(song);
        return song;
    }

    public String nowPlaying() {
        return current;
    }

    public int playCount(int id) {
        return playCounts.getOrDefault(id, 0);
    }

    public boolean queueLater(int id) {
        if (!library.containsKey(id)) {
            return false;
        }

        upNext.addLast(library.get(id));
        return true;
    }

    public boolean queueNext(int id) {
        if (!library.containsKey(id)) {
            return false;
        }

        upNext.addFirst(library.get(id));
        return true;
    }

    public List<String> showUpNext() {
        List<String> result = new LinkedList<>();

        for (String song : upNext) {
            if (library.containsValue(song)) {
                result.add(song);
            }
        }

        return result;
    }

    public String next() {
        String song = null;

        while (!upNext.isEmpty()) {
            String queued = upNext.pollFirst();

            if (library.containsValue(queued)) {
                song = queued;
                break;
            }
        }

        if (song == null && current != null) {
            int index = playList.indexOf(current);

            if (index != -1 && index + 1 < playList.size()) {
                song = playList.get(index + 1);
            }
        }

        if (song == null) {
            return null;
        }

        if (current != null) {
            history.push(current);
        }

        startSong(song);
        return song;
    }

    public String back() {
        String previous = null;

        while (!history.isEmpty()) {
            String candidate = history.pop();

            if (library.containsValue(candidate)) {
                previous = candidate;
                break;
            }
        }

        if (previous == null) {
            return null;
        }

        if (current != null) {
            upNext.addFirst(current);
        }

        startSong(previous);
        return previous;
    }

    public List<String> showHistory() {
        List<String> result = new LinkedList<>();

        for (String song : history) {
            if (library.containsValue(song)) {
                result.add(song);
            }
        }

        return result;
    }

    public boolean removeSong(int id) {
        if (!library.containsKey(id)) {
            return false;
        }

        String song = library.get(id);

        if (song.equals(current)) {
            return false;
        }

        library.remove(id);
        playCounts.remove(id);
        playList.remove(song);

        
        return true;
    }
}
