import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
    }

    void run(){
        int lastId = 1;
        List<Article> articleList = new ArrayList<>();
        System.out.println("== 게시판 앱 ==");
        System.out.printf("명령) ");

        while(true) {
            String command = sc.nextLine().trim();
            if (command.equals("종료")) {
                break;
            } else if (command.equals("등록")) {
                System.out.println("제목을 입력해주세요.");
                String title = sc.nextLine().trim();
                System.out.println("내용을 입력해주세요.");
                String content = sc.nextLine().trim();

                Article article = new Article(lastId, title, content);
                articleList.add(article);

                System.out.printf("제목 : %s\n", title);
                System.out.printf("내용 : %s\n", content);
                System.out.printf("%d번 게시물이 등록되었습니다. \n", lastId);
                lastId++;
            }else if(command.equals("목록")){
                System.out.println("번호 / 제목 / 내용");
                System.out.println("------------------");
                for(int i = 0; i < lastId; i++){
                    Article article = articleList.get(i);
                    System.out.printf("%d / %s / %s\n", article.getLastId(), article.getTitle(), article.getContent());
                }
            }
        }
    }
}
