For this question: http://stackoverflow.com/questions/29059045/answers-is-not-invoked-when-mocking-a-method-with-call-by-name-parameter?noredirect=1#comment47655260_29059045

Now run:

    ./sbt test
    
The test is still failed with error:

```
> test
######### run in invokeLater
[info] HelloWorldSpec
[info]
[info] something should
[error]   x do something
[error]    The mock was not called as expected:
[error]    printString.apply("Hello world");
[error]    Wanted 1 time:
[error]    -> at my.HelloWorldSpec$$anonfun$1$$anonfun$apply$3$$anonfun$apply$2.apply$mcV$sp(HelloWorldSpec.scala:22)
[error]    But was 3 times. Undesired invocation:
[error]    -> at my.HelloWorld.apply(HelloWorld.scala:5) (HelloWorldSpec.scala:22)
[info]
[info]
[info] Total for specification HelloWorldSpec
[info] Finished in 299 ms
[info] 1 example, 1 failure, 0 error
[error] Failed: Total 1, Failed 1, Errors 0, Passed 0
[error] Failed tests:
[error] 	my.HelloWorldSpec
[error] (test:test) sbt.TestsFailedException: Tests unsuccessful
[error] Total time: 1 s, completed Apr 22, 2015 12:27:41 AM
```

Not sure where is wrong.
