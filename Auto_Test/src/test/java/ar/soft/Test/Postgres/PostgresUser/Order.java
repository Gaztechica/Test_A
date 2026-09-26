package ar.soft.Test.Postgres.PostgresUser;

public record Order(

            int id,
            int userId,
            double amount,
            String status
    ) {}

