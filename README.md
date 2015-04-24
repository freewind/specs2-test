Make some functionalities clear in specs2.
==========================================

Call-by-name
------------

Now run:

    ./sbt test-only my.VerifyCallByNameSpec
    
The test is still failed with error:

```
> test-only my.VerifyCallByNameSpec
[info] Compiling 2 Scala sources to /Users/twer/workspace/specs2-test/target/scala-2.11/test-classes...
######### run in invokeLater
[info] VerifyCallByNameSpec
[info]
[info] mock a method with call-by-name should
[error]   x run the code inside the answer block correctly
[error]    The mock was not called as expected:
[error]    printString.apply("Hello world");
[error]    Wanted 1 time:
[error]    -> at my.VerifyCallByNameSpec$$anonfun$1$$anonfun$apply$4$$anonfun$apply$3.apply$mcV$sp(VerifyCallByNameSpec.scala:46)
[error]    But was 3 times. Undesired invocation:
[error]    -> at my.VerifyCallByNameSpec$HelloWorld.apply(VerifyCallByNameSpec.scala:19) (VerifyCallByNameSpec.scala:46)
[info]
[info]
[info] Total for specification VerifyCallByNameSpec
[info] Finished in 312 ms
[info] 1 example, 1 failure, 0 error
[error] Failed: Total 1, Failed 1, Errors 0, Passed 0
[error] Failed tests:
[error] 	my.VerifyCallByNameSpec
[error] (test:testOnly) sbt.TestsFailedException: Tests unsuccessful
[error] Total time: 5 s, completed Apr 24, 2015 9:45:15 PM
>
```

Not sure where is wrong.

See this question: http://stackoverflow.com/questions/29059045/answers-is-not-invoked-when-mocking-a-method-with-call-by-name-parameter?noredirect=1#comment47655260_29059045
