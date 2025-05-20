package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Cars {
  private final List<Car> cars;

  public Cars(String[] names) {
    validateDuplicate(names);
    this.cars = new ArrayList<>();
    for (String name : names) {
      cars.add(new Car(name));
    }
  }

  private void validateDuplicate(String[] names) {
    Set<String> unique = new HashSet<>(Arrays.asList(names));
    if (unique.size() != names.length) {
      throw new IllegalArgumentException("중복된 자동차 이름은 허용되지 않습니다.");
    }
  }

  public void moveAll() {
    for (Car car : cars) {
      int random = Randoms.pickNumberInRange(0, 9);
      car.move(random);
    }
  }

  public List<Car> getCars() {
    return cars;
  }

  public List<String> findWinners() {
    int max = cars.stream()
        .mapToInt(Car::getPosition)
        .max()
        .orElse(0);

    List<String> winners = new ArrayList<>();
    for (Car car : cars) {
      if (car.getPosition() == max) {
        winners.add(car.getName());
      }
    }
    return winners;
  }
}