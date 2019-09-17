package com.yan.linking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@Table(name = "appraise_user_grade_table")
public class UserGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * 做出评价的用户id
     */
    private int userId;

    /**
     * 用户分值，ug_1 代表id=1用户的得分
     */
    private String ug_1;
    /**
     * 用户分值，ug_2 代表id=2用户的得分
     */
    private String ug_2;
    private String ug_3;
    private String ug_4;
    private String ug_5;
    private String ug_6;
    private String ug_7;
    private String ug_8;
    private String ug_9;
    private String ug_10;
    private String ug_11;
    private String ug_12;
    private String ug_13;
    private String ug_14;
    private String ug_15;
    private String ug_16;
    private String ug_17;
    private String ug_18;
    private String ug_19;
    private String ug_20;
    private String ug_21;
    private String ug_22;
    private String ug_23;
    private String ug_24;
    private String ug_25;
    private String ug_26;
    private String ug_27;
    private String ug_28;
    private String ug_29;
    private String ug_30;
    private String ug_31;
    private String ug_32;
    private String ug_33;
    private String ug_34;
    private String ug_35;
    private String ug_36;
    private String ug_37;
    private String ug_38;
    private String ug_39;
    private String ug_40;
    private String ug_41;
    private String ug_42;
    private String ug_43;
    private String ug_44;
    private String ug_45;
    private String ug_46;
    private String ug_47;
    private String ug_48;
    private String ug_49;
    private String ug_50;
    private String ug_51;


    public UserGrade() {
    }

    public String getValue(String ug_id) {
        int ug_id_int = Integer.parseInt(ug_id);

        switch (ug_id_int) {
            case 1:
                return ug_1;
            case 2:
                return ug_2;
            case 3:
                return ug_3;
            case 4:
                return ug_4;
            case 5:
                return ug_5;
            case 6:
                return ug_6;
            case 7:
                return ug_7;
            case 8:
                return ug_8;
            case 9:
                return ug_9;
            case 10:
                return ug_10;
            case 11:
                return ug_11;
            case 12:
                return ug_12;
            case 13:
                return ug_13;
            case 14:
                return ug_14;
            case 15:
                return ug_15;
            case 16:
                return ug_16;
            case 17:
                return ug_17;
            case 18:
                return ug_18;
            case 19:
                return ug_19;
            case 20:
                return ug_20;
            case 21:
                return ug_21;
            case 22:
                return ug_22;
            case 23:
                return ug_23;
            case 24:
                return ug_24;
            case 25:
                return ug_25;
            case 26:
                return ug_26;
            case 27:
                return ug_27;
            case 28:
                return ug_28;
            case 29:
                return ug_29;
            case 30:
                return ug_30;
            case 31:
                return ug_31;
            case 32:
                return ug_32;
            case 33:
                return ug_33;
            case 34:
                return ug_34;
            case 35:
                return ug_35;
            case 36:
                return ug_36;
            case 37:
                return ug_37;
            case 38:
                return ug_38;
            case 39:
                return ug_39;
            case 40:
                return ug_40;
            case 41:
                return ug_41;
            case 42:
                return ug_42;
            case 43:
                return ug_43;
            case 44:
                return ug_44;
            case 45:
                return ug_45;
            case 46:
                return ug_46;
            case 47:
                return ug_47;
            case 48:
                return ug_48;
            case 49:
                return ug_49;
            case 50:
                return ug_50;
            case 51:
                return ug_51;
            default:
                return null;
        }

    }


}
