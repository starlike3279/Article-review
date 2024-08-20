import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    Scanner sc;

    App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.println("== 게시판 앱 == ");
        Map<Integer, Article> articleMap = new HashMap<>();
        int lastId = 1;

        while (true) {
            System.out.print("명령) ");
            String command = sc.nextLine().trim();

            if (command.equals("종료")) {
                break;
            } else if (command.equals("등록")) {
                System.out.print("제목 : ");
                String title = sc.nextLine().trim();
                System.out.print("내용 : ");
                String content = sc.nextLine().trim();
                System.out.printf("%d번 게시글이 등록되었습니다.\n", lastId);

                Article article = new Article(lastId, title, content);
                articleMap.put(lastId, article);

                lastId++;
            } else if (command.equals("목록")) {
                System.out.println("번호 / 제목 / 내용");
                System.out.println("----------------------");
                for (int id : articleMap.keySet()) {
                    Article article = articleMap.get(id);
                    System.out.printf("%d / %s / %s \n", article.getId(), article.getTitle(), article.getContent());
                }
            } else if (command.startsWith("삭제") || command.equals("삭제")) {
                String[] commandList = command.split("\\?", 2);
                if (commandList.length < 2) {
                    System.out.println("삭제할 게시물의 ID를 입력하세요.");
                    continue;
                }
                String[] paramStr = commandList[1].split("=", 2);
                if (paramStr.length < 2) {
                    System.out.println("삭제할 게시물의 ID를 입력하세요.");
                    continue;
                }

                String value = paramStr[1];
                int idx = Integer.parseInt(value);

                Article article = articleMap.remove(idx);
                if (article == null) {
                    System.out.printf("%d번 게시물은 존재하지 않습니다.\n", idx);
                } else {
                    System.out.printf("%d번 게시물이 삭제되었습니다. \n", idx);
                }
            } else if (command.startsWith("수정") || command.equals(("수정"))) {
                String[] commandList = command.split("\\?", 2);
                if (commandList.length < 2) {
                    System.out.println("수정할 게시물의 ID를 입력하세요.");
                    continue;
                }
                String[] paramsStr = commandList[1].split("=", 2);
                if (paramsStr.length < 2) {
                    System.out.println("수정할 게시물의 ID를 입력하세요.");
                    continue;
                }

                String value = paramsStr[1];
                int idx = Integer.parseInt(value);

                Article article = articleMap.get(idx);
                if (article == null) {
                    System.out.printf("%d번 게시물은 존재하지 않습니다.\n", idx);
                } else {
                    System.out.printf("제목(기존) : %s\n", article.getTitle());
                    System.out.print("제목 : ");
                    String modifySubject = sc.nextLine();
                    article.setTitle(modifySubject);

                    System.out.printf("내용(기존) : %s\n", article.getContent());
                    System.out.print("내용 : ");
                    String modifyContent = sc.nextLine();
                    article.setContent(modifyContent);

                    System.out.printf("%d번 게시물이 수정되었습니다.\n", idx);
                }
            } else {
                System.out.println("알 수 없는 명령어입니다.");
            }
        }
    }
}
