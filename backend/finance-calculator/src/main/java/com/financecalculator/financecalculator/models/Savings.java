package com.financecalculator.financecalculator.models;

import jakarta.persistence.Entity;


@Entity
public class Savings extends Allocation{}


//CREATE BASE CLASS "MAPPED SUPER CLASS" TO EXTEND TO SAVINGS AND OTHER ALLOCATION CLASSES