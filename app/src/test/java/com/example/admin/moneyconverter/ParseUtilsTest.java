package com.example.admin.moneyconverter;

import com.example.admin.moneyconverter.model.ValCurs;
import com.example.admin.moneyconverter.utils.ParseUtils;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author Nikolay Vlaskin on 13.02.2018.
 */

public class ParseUtilsTest {

    private String xml;

    @Before
    public void setUp() throws Exception {
        xml = initXML();
    }

    @Test
    public void calculate() throws Exception {
        assertEquals(true, checkExistData());
    }

    private boolean checkExistData(){
        ValCurs model = ParseUtils.parseXML(xml);
        if (model != null) {
            System.out.println(model.getDate());
            System.out.println(model.getValute().get(0).getName());
            System.out.println(model.getValute().get(0).getValue());
            return true;
        } else return false;
    }

    private String initXML(){
        return  "<?xml version=\"1.0\" encoding=\"WINDOWS-1251\"?>\n" +
                "<ValCurs name=\"Foreign Currency Market\" Date=\"10.02.2018\">\n" +
                "<Valute ID=\"R01010\">\n" +
                "<NumCode>036</NumCode>\n" +
                "<CharCode>AUD</CharCode>\n" +
                "<Nominal>1</Nominal>\n" +
                "<Name>Австралийский доллар</Name>\n" +
                "<Value>45,2344</Value>\n" +
                "</Valute>\n" +
                "<Valute ID=\"R01020A\">\n" +
                "<NumCode>944</NumCode>\n" +
                "<CharCode>AZN</CharCode>\n" +
                "<Nominal>1</Nominal>\n" +
                "<Name>Азербайджанский манат</Name>\n" +
                "<Value>34,1685</Value>\n" +
                "</Valute>\n" +
                "<Valute ID=\"R01035\">\n" +
                "<NumCode>826</NumCode>\n" +
                "<CharCode>GBP</CharCode>\n" +
                "<Nominal>1</Nominal>\n" +
                "<Name>Фунт стерлингов Соединенного королевства</Name>\n" +
                "<Value>81,1555</Value>\n" +
                "</Valute>\n" +
                "<Valute ID=\"R01060\">\n" +
                "<NumCode>051</NumCode>\n" +
                "<CharCode>AMD</CharCode>\n" +
                "<Nominal>100</Nominal>\n" +
                "<Name>Армянских драмов</Name>\n" +
                "<Value>12,0439</Value>\n" +
                "</Valute>\n" +
                "<Valute ID=\"R01090B\">\n" +
                "<NumCode>933</NumCode>\n" +
                "<CharCode>BYN</CharCode>\n" +
                "<Nominal>1</Nominal>\n" +
                "<Name>Белорусский рубль</Name>\n" +
                "<Value>29,0786</Value>\n" +
                "</Valute>\n" +
                "<Valute ID=\"R01100\">\n" +
                "<NumCode>975</NumCode>\n" +
                "<CharCode>BGN</CharCode>\n" +
                "<Nominal>1</Nominal>\n" +
                "<Name>Болгарский лев</Name>\n" +
                "<Value>36,4736</Value>\n" +
                "</Valute>\n" +
                "<Valute ID=\"R01115\">\n" +
                "<NumCode>986</NumCode>\n" +
                "<CharCode>BRL</CharCode>\n" +
                "<Nominal>1</Nominal>\n" +
                "<Name>Бразильский реал</Name>\n" +
                "<Value>17,7040</Value>\n" +
                "</Valute>\n" +
                "<Valute ID=\"R01135\">\n" +
                "<NumCode>348</NumCode>\n" +
                "<CharCode>HUF</CharCode>\n" +
                "<Nominal>100</Nominal>\n" +
                "<Name>Венгерских форинтов</Name>\n" +
                "<Value>22,8964</Value>\n" +
                "</Valute>\n" +
                "<Valute ID=\"R01200\">\n" +
                "<NumCode>344</NumCode>\n" +
                "<CharCode>HKD</CharCode>\n" +
                "<Nominal>10</Nominal>\n" +
                "<Name>Гонконгских долларов</Name>\n" +
                "<Value>74,3894</Value>\n" +
                "</Valute>\n" +
                "<Valute ID=\"R01215\">\n" +
                "<NumCode>208</NumCode>\n" +
                "<CharCode>DKK</CharCode>\n" +
                "<Nominal>10</Nominal>\n" +
                "<Name>Датских крон</Name>\n" +
                "<Value>95,8460</Value>\n" +
                "</Valute>\n" +
                "<Valute ID=\"R01235\">\n" +
                "<NumCode>840</NumCode>\n" +
                "<CharCode>USD</CharCode>\n" +
                "<Nominal>1</Nominal>\n" +
                "<Name>Доллар США</Name>\n" +
                "<Value>58,1718</Value>\n" +
                "</Valute>\n" +
                "<Valute ID=\"R01239\">\n" +
                "<NumCode>978</NumCode>\n" +
                "<CharCode>EUR</CharCode>\n" +
                "<Nominal>1</Nominal>\n" +
                "<Name>Евро</Name>\n" +
                "<Value>71,3943</Value>\n" +
                "</Valute>\n" +
                "<Valute ID=\"R01270\">\n" +
                "<NumCode>356</NumCode>\n" +
                "<CharCode>INR</CharCode>\n" +
                "<Nominal>100</Nominal>\n" +
                "<Name>Индийских рупий</Name>\n" +
                "<Value>90,3710</Value>\n" +
                "</Valute>\n" +
                "<Valute ID=\"R01335\">\n" +
                "<NumCode>398</NumCode>\n" +
                "<CharCode>KZT</CharCode>\n" +
                "<Nominal>100</Nominal>\n" +
                "<Name>Казахстанских тенге</Name>\n" +
                "<Value>17,7651</Value>\n" +
                "</Valute>\n" +
                "<Valute ID=\"R01350\">\n" +
                "<NumCode>124</NumCode>\n" +
                "<CharCode>CAD</CharCode>\n" +
                "<Nominal>1</Nominal>\n" +
                "<Name>Канадский доллар</Name>\n" +
                "<Value>46,1461</Value>\n" +
                "</Valute>\n" +
                "<Valute ID=\"R01370\">\n" +
                "<NumCode>417</NumCode>\n" +
                "<CharCode>KGS</CharCode>\n" +
                "<Nominal>100</Nominal>\n" +
                "<Name>Киргизских сомов</Name>\n" +
                "<Value>84,6825</Value>\n" +
                "</Valute>\n" +
                "<Valute ID=\"R01375\">\n" +
                "<NumCode>156</NumCode>\n" +
                "<CharCode>CNY</CharCode>\n" +
                "<Nominal>10</Nominal>\n" +
                "<Name>Китайских юаней</Name>\n" +
                "<Value>92,3245</Value>\n" +
                "</Valute>\n" +
                "<Valute ID=\"R01500\">\n" +
                "<NumCode>498</NumCode>\n" +
                "<CharCode>MDL</CharCode>\n" +
                "<Nominal>10</Nominal>\n" +
                "<Name>Молдавских леев</Name>\n" +
                "<Value>34,8961</Value>\n" +
                "</Valute>\n" +
                "<Valute ID=\"R01535\">\n" +
                "<NumCode>578</NumCode>\n" +
                "<CharCode>NOK</CharCode>\n" +
                "<Nominal>10</Nominal>\n" +
                "<Name>Норвежских крон</Name>\n" +
                "<Value>72,9372</Value>\n" +
                "</Valute>\n" +
                "<Valute ID=\"R01565\">\n" +
                "<NumCode>985</NumCode>\n" +
                "<CharCode>PLN</CharCode>\n" +
                "<Nominal>1</Nominal>\n" +
                "<Name>Польский злотый</Name>\n" +
                "<Value>17,0392</Value>\n" +
                "</Valute>\n" +
                "<Valute ID=\"R01585F\">\n" +
                "<NumCode>946</NumCode>\n" +
                "<CharCode>RON</CharCode>\n" +
                "<Nominal>1</Nominal>\n" +
                "<Name>Румынский лей</Name>\n" +
                "<Value>15,3463</Value>\n" +
                "</Valute>\n" +
                "<Valute ID=\"R01589\">\n" +
                "<NumCode>960</NumCode>\n" +
                "<CharCode>XDR</CharCode>\n" +
                "<Nominal>1</Nominal>\n" +
                "<Name>СДР (специальные права заимствования)</Name>\n" +
                "<Value>84,0297</Value>\n" +
                "</Valute>\n" +
                "<Valute ID=\"R01625\">\n" +
                "<NumCode>702</NumCode>\n" +
                "<CharCode>SGD</CharCode>\n" +
                "<Nominal>1</Nominal>\n" +
                "<Name>Сингапурский доллар</Name>\n" +
                "<Value>43,6660</Value>\n" +
                "</Valute>\n" +
                "<Valute ID=\"R01670\">\n" +
                "<NumCode>972</NumCode>\n" +
                "<CharCode>TJS</CharCode>\n" +
                "<Nominal>10</Nominal>\n" +
                "<Name>Таджикских сомони</Name>\n" +
                "<Value>65,9664</Value>\n" +
                "</Valute>\n" +
                "<Valute ID=\"R01700J\">\n" +
                "<NumCode>949</NumCode>\n" +
                "<CharCode>TRY</CharCode>\n" +
                "<Nominal>1</Nominal>\n" +
                "<Name>Турецкая лира</Name>\n" +
                "<Value>15,2402</Value>\n" +
                "</Valute>\n" +
                "<Valute ID=\"R01710A\">\n" +
                "<NumCode>934</NumCode>\n" +
                "<CharCode>TMT</CharCode>\n" +
                "<Nominal>1</Nominal>\n" +
                "<Name>Новый туркменский манат</Name>\n" +
                "<Value>16,6438</Value>\n" +
                "</Valute>\n" +
                "<Valute ID=\"R01717\">\n" +
                "<NumCode>860</NumCode>\n" +
                "<CharCode>UZS</CharCode>\n" +
                "<Nominal>10000</Nominal>\n" +
                "<Name>Узбекских сумов</Name>\n" +
                "<Value>71,0547</Value>\n" +
                "</Valute>\n" +
                "<Valute ID=\"R01720\">\n" +
                "<NumCode>980</NumCode>\n" +
                "<CharCode>UAH</CharCode>\n" +
                "<Nominal>10</Nominal>\n" +
                "<Name>Украинских гривен</Name>\n" +
                "<Value>21,4775</Value>\n" +
                "</Valute>\n" +
                "<Valute ID=\"R01760\">\n" +
                "<NumCode>203</NumCode>\n" +
                "<CharCode>CZK</CharCode>\n" +
                "<Nominal>10</Nominal>\n" +
                "<Name>Чешских крон</Name>\n" +
                "<Value>28,1649</Value>\n" +
                "</Valute>\n" +
                "<Valute ID=\"R01770\">\n" +
                "<NumCode>752</NumCode>\n" +
                "<CharCode>SEK</CharCode>\n" +
                "<Nominal>10</Nominal>\n" +
                "<Name>Шведских крон</Name>\n" +
                "<Value>71,6640</Value>\n" +
                "</Valute>\n" +
                "<Valute ID=\"R01775\">\n" +
                "<NumCode>756</NumCode>\n" +
                "<CharCode>CHF</CharCode>\n" +
                "<Nominal>1</Nominal>\n" +
                "<Name>Швейцарский франк</Name>\n" +
                "<Value>61,9706</Value>\n" +
                "</Valute>\n" +
                "<Valute ID=\"R01810\">\n" +
                "<NumCode>710</NumCode>\n" +
                "<CharCode>ZAR</CharCode>\n" +
                "<Nominal>10</Nominal>\n" +
                "<Name>Южноафриканских рэндов</Name>\n" +
                "<Value>48,1164</Value>\n" +
                "</Valute>\n" +
                "<Valute ID=\"R01815\">\n" +
                "<NumCode>410</NumCode>\n" +
                "<CharCode>KRW</CharCode>\n" +
                "<Nominal>1000</Nominal>\n" +
                "<Name>Вон Республики Корея</Name>\n" +
                "<Value>53,4353</Value>\n" +
                "</Valute>\n" +
                "<Valute ID=\"R01820\">\n" +
                "<NumCode>392</NumCode>\n" +
                "<CharCode>JPY</CharCode>\n" +
                "<Nominal>100</Nominal>\n" +
                "<Name>Японских иен</Name>\n" +
                "<Value>53,2489</Value>\n" +
                "</Valute>\n" +
                "</ValCurs>";
    }
}
