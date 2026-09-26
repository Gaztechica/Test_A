package ar.soft.Test.Postgres.Database;

public record Order(

            int id,
            int userId,
            double amount,
            String status
    ) {}

