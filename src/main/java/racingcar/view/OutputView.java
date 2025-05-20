package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;

public class OutputView {
  public static void printResultMessage() {
    System.out.println("\n실행 결과");
  }

  public static void printTurn(Cars cars) {
    for (Car car : cars.getCars()) {
      System.out.println(car.render());
    }
    System.out.println();
  }

  public static void printWinners(List<String> winners) {
    System.out.println("최종 우승자 : " + String.join(", ", winners));
  }
}
