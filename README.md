# Java TDD Projects

This is a collection of Java projects and Katas built following Test-Driven Development (TDD).
Each problem will have its own feature branch (`f-<project-name>`).

## Video Store

This repo will address this [Video Store Kata](https://learn.madetech.com/technology/katas/video-store/).

## Problem

Write a system that can build a `statement`, when given `rentals`.

When there are 3 regular movie rentals for 1, 2 and 3 days respectively, the statement looks like:

```
Rental Record for Customer Name
    Crazynotes  £2.0
    Teeth  £2.0
    The Web  £3.5
You owe £7.5
You earned 3 frequent renter points
```

### Regular Movies

These cost £2 for the first 2 days, and £1.50 for each day thereafter.

You earn 1 frequent renter point no matter the length of the rental.

### New Release Movies

These cost £3 per day.

You earn 1 frequent renter point for a 1 day rental, and 2 for any rental of 2 days or more.

### Childrens Movies

These cost £1.50 for the first 3 days, and £1.50 for each day thereafter.

You earn 1 frequent renter point no matter the length of the rental.

## Key points

- need a user class, name, rental points
- there are three types of movies - Movie parent class, Regular/New/Childrens subclasses
- rentals, which have a user and the movies
- generateStatement must take multiple statement options, use varargs
