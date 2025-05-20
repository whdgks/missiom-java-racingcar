package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
  public void run() {
    Cars cars = new Cars(InputView.readCarNames()); // 예외 발생 시 throw 됨
    int tryCount = InputView.readTryCount();        // 예외 발생 시 throw 됨

    OutputView.printResultMessage();
    for (int i = 0; i < tryCount; i++) {
      cars.moveAll();
      OutputView.printTurn(cars);
    }
    OutputView.printWinners(cars.findWinners());
  }
}
