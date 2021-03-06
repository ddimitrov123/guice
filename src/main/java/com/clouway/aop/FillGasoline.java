package com.clouway.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.METHOD)
public @interface FillGasoline {}
