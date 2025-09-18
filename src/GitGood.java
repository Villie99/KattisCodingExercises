import java.util.*;

public class GitGood {
    public static void main(String[] args) {
        new GitGood().gitGood();
    }

    public void gitGood() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<String> currentPath = new ArrayList<>();
        Set<String> fileSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();

            if (line.startsWith("cd ")) {
                String folder = line.substring(3);
                if (folder.equals("..")) {
                    if (!currentPath.isEmpty()) {
                        currentPath.remove(currentPath.size() - 1);
                    }
                } else {
                    currentPath.add(folder);
                }
            } else if (line.startsWith("nano ")) {
                String file = line.substring(5);
                StringBuilder fullPath = new StringBuilder();
                for (String folder : currentPath) {
                    fullPath.append(folder).append("/");
                }
                fullPath.append(file);
                fileSet.add(fullPath.toString());
            }
        }

        List<String> sortedFiles = new ArrayList<>(fileSet);
        Collections.sort(sortedFiles);

        for (String path : sortedFiles) {
            System.out.println("git add " + path);
        }
        System.out.println("git commit");
        System.out.println("git push");
    }
}
