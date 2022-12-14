package helpers;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"file:src/main/resources/properties/main.properties",
        "system:properties",
        "system:env"})
/**
 * Интерфейс для доступа к файлу .property.
 * Имя переменной должно быть таким же, как в файле .property. Если же оно отличается, то нужно
 * использовать аанотацию @Key.
 * На всякий случай можно использовать @DefaultValue("5") для установления значения по умолчанию.
 *
 */
public interface MainProperties extends Config {
    /**
     * Поле defaultTimeout для использования значения по ключу "timeout.default" из файла
     * src/main/resources/properties/main.properties.
     *
     * @return возвращает значение из main.properties
     */
    @Key("timeout.default30")
    int defaultTimeout30();

    /**
     * короткий таймаут 2 секунды
     *
     * @return
     */
    @Key("timeout.short2")
    int timeoutShort2();
    /**
     * короткий таймаут 3 секунды
     *
     * @return
     */
    @Key("timeout.short3")
    int timeoutShort3();
    /**
     * короткий таймаут 5 секунд
     *
     * @return
     */
    @Key("timeout.short5")
    int timeoutShort5();

    /**
     * @return возвращает значение браузера для использования
     */
    String browser();

    /**
     * @return возвращает адрес странички для старта теста
     */
    @Key("base_url")
    String baseUrl();

    /**
     * @return возвращает тип драйвера
     */
    @Key("driver")
    String driver();
    /**
     * адрес почты
     */
    @Key("mailaddress")
    String mailaddress();
    /**
     * пароль от почты
     */
    @Key("mailpass")
    String mailpass();
}
