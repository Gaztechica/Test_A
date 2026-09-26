package ar.soft.Test.BD;

public record Order(

            int id,
            int userId,
            double amount,
            String status
    ) {}

