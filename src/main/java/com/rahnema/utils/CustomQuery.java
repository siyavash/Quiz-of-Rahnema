package com.rahnema.utils;

/**
 * Created by siyavash on 5/17/2017.
 */

public final class CustomQuery {

    public static final String getNewQuestions =
            "SELECT question.id " +
            "FROM question " +
            "WHERE question.id NOT IN (" +
                "SELECT question_account.question_id " +
                "FROM question_account " +
                "WHERE question_account.account_id = ? " +
                "GROUP BY question_id) " +
            "ORDER BY rand() " +
            "LIMIT ?";

    public static final String getDuplicateQuestions =
            "SELECT question_account.question_id " +
            "FROM question_account " +
            "WHERE account_id = ? " +
            "GROUP BY question_id " +
            "ORDER BY rand() " +
            "LIMIT ?";

    public static final String getQuestionsById =
            "select p from Question p where p.id in :ids";
}
