package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
  public static String[] readCarNames() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String input = Console.readLine();
    if (input == null || input.isBlank()) {
      throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
    }
    String[] names = input.split(",");
    for (String name : names) {
      if (name.isBlank()) {
        throw new IllegalArgumentException("빈 이름이 포함되어 있습니다.");
      }
    }
    return names;
  }

  public static int readTryCount() {
    System.out.println("시도할 회수는 몇회인가요?");
    String input = Console.readLine();
    try {
      int count = Integer.parseInt(input);
      if (count <= 0) {
        throw new IllegalArgumentException("시도 횟수는 양의 정수여야 합니다.");
      }
      return count;
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("숫자를 입력해야 합니다.");
    }
  }
}