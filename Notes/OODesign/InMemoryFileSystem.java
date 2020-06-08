package OODesign;

import java.util.*;

public class InMemoryFileSystem {

    class File {
        boolean isFile = false;
        Map<String, File> files = new HashMap<>();
        String content = "";
    }

    File root;
    public InMemoryFileSystem() {
        root = new File();
    }

    //O(m+n + k log k)
    public List<String> ls(String path) {
        File t = root;
        List<String> fileList = new ArrayList<>();
        if(path.contains("/")) {

            String[] d = path.split("/");
            for(int i = 1; i<d.length; i++) {
                t = t.files.get(d[i]);
            }
            if(t.isFile) {
                fileList.add(d[d.length-1]);
                return fileList;
            }
        }

        List<String> resFiles = new ArrayList<>(t.files.keySet());
        Collections.sort(resFiles);
        return resFiles;

    }

    // O(m+n)
    public void mkdir(String path) {
        File t = root;
        String[] d = path.split("/");
        for(int i = 1; i<d.length; i++) {
            if(!t.files.containsKey(d[i])) {
                t.files.put(d[i],new File());
            }
            t = t.files.get(d[i]);
        }
    }

    // O(m+n)
    public void addContentToFile(String filePath, String content) {
        File t = root;
        String[] d = filePath.split("/");
        for(int i = 1; i<d.length-1; i++) {
            t = t.files.get(d[i]);
        }
        if(!t.files.containsKey(d[d.length-1])) {
            t.files.put(d[d.length-1], new File());
        }
        t = t.files.get(d[d.length -1]);
        t.content = t.content + content;
        t.isFile = true;
    }

    // O(m+n)
    public String readContentFromFile(String filePath) {
        File t = root;
        String[] d = filePath.split("/");
        for(int i = 1; i < d.length-1; i++) {
            t = t.files.get(d[i]);
        }
        return t.files.get(d[d.length-1]).content;
    }


}
