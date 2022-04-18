package baseball;

import baseball.game.service.GameServiceImpl;

public class Application {
    public static void main(String[] args) {
        GameServiceImpl gameServiceImpl = new GameServiceImpl();
        gameServiceImpl.run();
    }
}
