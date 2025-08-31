package ru.qa.property.turbo;

/**
 * Константы основных стендов.
 * @author Evgeny Gribanov
 * @link egribanov@cbgr.ru
 * @since 08.07.2022 10:28
 */
public enum StandAddress {

  PLATFORM_TEST01("plt-dev.cbg.local/ib_Auto", "PLATFORM_TEST01"),
  PLATFORM_TEST02("172.17.117.210:25881/ib_Auto", "PLATFORM_TEST02"),
  PLATFORM_TEST04("plt-tst.cbg.local/ib_Auto", "PLATFORM_TEST04"),
//  PLATFORM_TEST01("plt-dev.cbg.local/ib_Auto_postgres", "PLATFORM_TEST01"),     //Auto_postgres эталонная база

  PLATFORM_TEST06("172.17.117.210:25885/ib_Auto", "PLATFORM_TEST06"),
  FRONT_PLT_TEST01("172.17.117.197:25880/ib_Auto", "FRONT_PLT_TEST01"),
  // platform
  TEST("test.turbo.cbg.local/auto", "TEST"),
  DEMO("172.17.117.119:25881/ib_Auto", "DEMO"),
  DEV("dev.turbo.cbg.local/auto", "DEV"),
  TEST_LTS("lts-test.turbo.cbg.local/auto", "TEST_LTS"),
  LINUX("test-orel.turbo.cbg.local:25881/Auto", "LINUX"),
  RELEASE("release.turbo.cbg.local/auto", "RELEASE"),
  NEXT_TEST("172.17.117.25:98/ib_Auto", "NEXT_TEST"),
  NEXT_DEV("172.17.117.25:96/ib_Auto", "NEXT_DEV"),
  DEV_NEXT("172.17.117.25:97/ib_Auto", "DEV_NEXT"),
  RELEASE1051("next.turbo.cbg.local/ib_Auto", "RELEASE1051"),
  NEXT_RELEASE("172.17.117.25:73/ib_Auto", "NEXT_RELEASE"),

  /**
   * Новый стенд для запуска на версии 1051
   */
  NEXT_DEV1051_NEW("172.17.117.25:92/ib_Auto", "NEXT_DEV1051_NEW"),
  NEXT_DEV1051_Old("172.17.117.25:92/ib_Auto_old_design", "NEXT_DEV1051_Old"),

  /**
   * Новый стенд для запуска на версии 1052
   */
  //NEXT_DEV1052_NEW("nextdev.turbo.cbg.local/ib_Auto", "NEXT_DEV1052_NEW"),
  NEXT_DEV1052_NEW("172.17.117.25:96/ib_Auto", "NEXT_DEV1052_NEW"),
//    NEXT_DEV1052_Old("172.17.117.25:96/ib_Auto", "NEXT_DEV1052_Old"),
  NEXT_DEV1052_ADMIN("172.17.117.25:96/ib_Admin", "NEXT_DEV1052_ADMIN"),
  DEV_NEXT1052_NEW("172.17.117.25:97/ib_Auto", "DEV_NEXT1052_NEW"),
//  DEV_NEXT1052_NEW("172.17.117.197:25882/ib_Auto", "DEV_NEXT1052_NEW"),                  //тестовая ветка со стендом для 97
  NEXT1052_NEW("172.17.117.25:94/ib_Auto", "NEXT1052_NEW"),
  LOCAL_TEST("localhost:3000/auto", "LOCAL_TEST"),
  LOCAL_MDRUCHILOV("localhost:81/ib_Admin", "LOCAL_MDRUCHILOV"),

  /*
  * Стенды для запуска RC пайплайна (НЕ УДАЛЯТЬ)
  * */
  TEST_UBUNTU("172.17.117.233:25880/ib_Auto", "TEST_UBUNTU"),
  TEST_ASTRA("172.17.117.234:25880/ib_Auto", "TEST_ASTRA"),
  TEST_ALTLINUX("172.17.117.240:25880/ib_Auto", "TEST_ALTLINUX"),
  TEST_CENTOS("172.17.117.241:25880/ib_Auto", "TEST_CENTOS"),
  TEST_WINDOWS("172.17.117.242:80/ib_Auto", "TEST_WINDOWS");

  /**
   * Новый стенд для запуска на версии ПРО
   */
//  PRO_DEV_1052_new("172.17.218.50:25880/ib_Auto", "PRO_DEV_1052_new");

  private final String url;
  private final String standName;

  StandAddress(String url, String standName) {
    this.url = url;
    this.standName = standName;
  }

  //public String getUrl() {
  //  return "http://" + USER + ":@" + url + "/webui/index.html#/";
  //}

  public String getUrl() {
    return "http://" + url + "/Login/Login";
  }

  public String getStandName() {
    return standName;
  }

  public static String getStandUrl(String standName) {
    for (StandAddress stand : StandAddress.values()) {
      if (stand.getStandName().equalsIgnoreCase(standName)) {
        return stand.getUrl();
      }
    }
    // Если стенд не найден, возвращаем URL для стенда TEST
    return TEST.getUrl();
  }
}