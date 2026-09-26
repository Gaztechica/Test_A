package ar.soft.Test.BD2;

public record Order(

            int id,
            int userId,
            double amount,
            String status
    ) {}

