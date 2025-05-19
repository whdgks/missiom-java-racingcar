package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
  private static final int MOVING_FORWARD = 4;
  private static final int STOP = 3;

  @Test
  void 경주_기능_정상작동_테스트() {
    assertRandomNumberInRangeTest(
        () -> {
          run("pobi,woni", "1");
          assertThat(output()).contains("pobi : -", "woni :", "최종 우승자 : pobi");
        },
        MOVING_FORWARD, STOP
    );
  }

  @Test
  void 자동차_이름_길이_초과_예외_테스트() {
    assertSimpleTest(() ->
        assertThatThrownBy(() -> runException("pobi,javaji", "1"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름은 공백 없이 1~5자 이내여야 합니다.")
    );
  }

  @Test
  void 중복된_이름_예외_테스트() {
    assertSimpleTest(() ->
        assertThatThrownBy(() -> runException("pobi,pobi", "1"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("중복된 자동차 이름은 허용되지 않습니다.")
    );
  }

  @Test
  void 시도횟수_음수_예외_테스트() {
    assertSimpleTest(() ->
        assertThatThrownBy(() -> runException("pobi,woni", "-2"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("시도 횟수는 양의 정수여야 합니다.")
    );
  }

  @Test
  void 시도횟수_문자입력_예외_테스트() {
    assertSimpleTest(() ->
        assertThatThrownBy(() -> runException("pobi,woni", "abc"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("숫자를 입력해야 합니다.")
    );
  }

  @Override
  public void runMain() {
    Application.main(new String[]{});
  }
}
