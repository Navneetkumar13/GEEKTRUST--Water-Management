package com.geektrust.backend.command;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;
import com.geektrust.backend.entity.Operators;

public class Commands {
    private Operators operator;
    private List<String> operands;

    public Commands(Operators operator, List<String> operands){
        if(operator == null){
            throw new NullPointerException();
        }
        if(operands == null){
            throw new NullPointerException();
        }
        this.operator = operator;
        this.operands = operands;
    }

    public Operators getOperator(){
        return operator;
    }

    public List<String> getOperands(){
        return operands;
    }

    public static Commands from(String str){
        try{
            String[] commandWithArguments = str.split(" ");
            Operators operator = Operators.valueOf(commandWithArguments[0]);
            List<String> operands = Arrays.stream(commandWithArguments).skip(1).collect(Collectors.toList());
            Commands command = new Commands(operator, operands);
            command.validateOperandCardinality();
            return command;
        }catch(Exception e){
            throw new UnsupportedOperationException("Invalid command supplied" + str);
        }
    }

    public void validateOperandCardinality(){
        if(this.operator.getNumberOfArguments() != operands.size()){
            throw new InputMismatchException("The number of arguments is not correct");
        }
    }
}
