package racingcar.domain;

public class Car {
  private static final int MOVE_THRESHOLD = 4;

  private final String name;
  private int position = 0;

  public Car(String name) {
    validateName(name);
    this.name = name;
  }

  private void validateName(String name) {
    if (name == null || name.isBlank() || name.length() > 5 || name.contains(" ")) {
      throw new IllegalArgumentException("자동차 이름은 공백 없이 1~5자 이내여야 합니다.");
    }
  }

  public void move(int number) {
    if (number >= MOVE_THRESHOLD) {
      position++;
    }
  }

  public String getName() {
    return name;
  }

  public int getPosition() {
    return position;
  }

  public String render() {
    return name + " : " + "-".repeat(position);
  }
}