package com.azusahikari.pgtools.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class underline {
    public static void main(String[] args) {
        String destStr = "    private Integer target_value_1_1;\n" +
                "    @Column(name = \"ability_type_1_2\", nullable = false)\n" +
                "    private Integer ability_type_1_2;\n" +
                "    @Column(name = \"ability_value_usage_1_2\", nullable = false)\n" +
                "    private Integer ability_value_usage_1_2;\n" +
                "    @Column(name = \"ability_value_level_usage_1_2\", nullable = false)\n" +
                "    private Integer ability_value_level_usage_1_2;\n" +
                "    @Column(name = \"float_ability_value_1_2\", nullable = false)\n" +
                "    private Integer float_ability_value_1_2;\n" +
                "    @Column(name = \"target_type_1_2\", nullable = false)\n" +
                "    private Integer target_type_1_2;\n" +
                "    @Column(name = \"target_value_1_2\", nullable = false)\n" +
                "    private Integer target_value_1_2;\n" +
                "    @Column(name = \"ability_type_1_3\", nullable = false)\n" +
                "    private Integer ability_type_1_3;\n" +
                "    @Column(name = \"ability_value_usage_1_3\", nullable = false)\n" +
                "    private Integer ability_value_usage_1_3;\n" +
                "    @Column(name = \"ability_value_level_usage_1_3\", nullable = false)\n" +
                "    private Integer ability_value_level_usage_1_3;\n" +
                "    @Column(name = \"float_ability_value_1_3\", nullable = false)\n" +
                "    private Integer float_ability_value_1_3;\n" +
                "    @Column(name = \"target_type_1_3\", nullable = false)\n" +
                "    private Integer target_type_1_3;\n" +
                "    @Column(name = \"target_value_1_3\", nullable = false)\n" +
                "    private Integer target_value_1_3;\n" +
                "    @Column(name = \"condition_2\", nullable = false)\n" +
                "    private Integer condition_2;\n" +
                "    @Column(name = \"float_ability_time_2\", nullable = false)\n" +
                "    private Integer float_ability_time_2;\n" +
                "    @Column(name = \"float_cooldown_time_2\", nullable = false)\n" +
                "    private Integer float_cooldown_time_2;\n" +
                "    @Column(name = \"ability_type_2_1\", nullable = false)\n" +
                "    private Integer ability_type_2_1;\n" +
                "    @Column(name = \"ability_value_usage_2_1\", nullable = false)\n" +
                "    private Integer ability_value_usage_2_1;\n" +
                "    @Column(name = \"ability_value_level_usage_2_1\", nullable = false)\n" +
                "    private Integer ability_value_level_usage_2_1;\n" +
                "    @Column(name = \"float_ability_value_2_1\", nullable = false)\n" +
                "    private Integer float_ability_value_2_1;\n" +
                "    @Column(name = \"target_type_2_1\", nullable = false)\n" +
                "    private Integer target_type_2_1;\n" +
                "    @Column(name = \"target_value_2_1\", nullable = false)\n" +
                "    private Integer target_value_2_1;\n" +
                "    @Column(name = \"ability_type_2_2\", nullable = false)\n" +
                "    private Integer ability_type_2_2;\n" +
                "    @Column(name = \"ability_value_usage_2_2\", nullable = false)\n" +
                "    private Integer ability_value_usage_2_2;\n" +
                "    @Column(name = \"ability_value_level_usage_2_2\", nullable = false)\n" +
                "    private Integer ability_value_level_usage_2_2;\n" +
                "    @Column(name = \"float_ability_value_2_2\", nullable = false)\n" +
                "    private Integer float_ability_value_2_2;\n" +
                "    @Column(name = \"target_type_2_2\", nullable = false)\n" +
                "    private Integer target_type_2_2;\n" +
                "    @Column(name = \"target_value_2_2\", nullable = false)\n" +
                "    private Integer target_value_2_2;\n" +
                "    @Column(name = \"ability_type_2_3\", nullable = false)\n" +
                "    private Integer ability_type_2_3;\n" +
                "    @Column(name = \"ability_value_usage_2_3\", nullable = false)\n" +
                "    private Integer ability_value_usage_2_3;\n" +
                "    @Column(name = \"ability_value_level_usage_2_3\", nullable = false)\n" +
                "    private Integer ability_value_level_usage_2_3;";

        String[] destStrs = destStr.split("\n");

        StringBuilder sb = new StringBuilder();
        for (String s : destStrs) {
            if (s.contains("private")) {
                Pattern p = Pattern.compile("_[a-z0-9]");
                Matcher m = p.matcher(s);
                while (m.find()) {
                    String firstChar = m.group().substring(1, 2);
                    m.appendReplacement(sb, firstChar.toUpperCase());
                }
                m.appendTail(sb);
            } else {
                sb.append(s);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
