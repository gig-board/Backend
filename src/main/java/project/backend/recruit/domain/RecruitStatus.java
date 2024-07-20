package project.backend.recruit.domain;

import java.util.Locale;

public enum RecruitStatus {

    EXPECTED, PROGRESS, END;

    public static RecruitStatus fromName(String status) {
        return RecruitStatus.valueOf(status.toUpperCase(Locale.ENGLISH));
    }

}
