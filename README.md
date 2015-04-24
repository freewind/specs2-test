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

VerifyWithContain
-----------------

`VerifyWithContainSpec` is passed from sbt command line, but failed running inside IDEA directly.

```
$ ./sbt
> test-only my.VerifyWithContainSpec
[info] VerifyWithContainSpec
[info]
[info] contain() in sendString() should
[info]   when client send a string 'abc', the connection should
[info]     + send the string 'abc'
[info]     + send a string contain(b)
[info]     + not send a string contain(x)
[info] contain() in sendObject() should
[info]   when client send a string 'abc', the connection should
[info]     + send the string 'abc'
[info]     + send a string contain(b)
[info]     + not send a string contain(x)
[info]
[info] Total for specification VerifyWithContainSpec
[info] Finished in 91 ms
[info] 6 examples, 0 failure, 0 error
[info] Passed: Total 6, Failed 0, Errors 0, Passed 6
[success] Total time: 1 s, completed Apr 24, 2015 9:48:00 PM
>
```

Running in IDEA:

```

The mock was not called as expected: 
Argument(s) are different! Wanted:
connection.sendObject(
    org.specs2.matcher.StringBaseMatchers$$anon$2@537a7706
);
-> at my.VerifyWithContainSpec$$anonfun$2$$anonfun$apply$11$$anonfun$apply$13$$anonfun$apply$5.apply$mcV$sp(VerifyWithContainSpec.scala:48)
Actual invocation has different arguments:
connection.sendObject(
    "abc"
);
-> at my.VerifyWithContainSpec$Client.helloObject(VerifyWithContainSpec.scala:16)

java.lang.Exception: The mock was not called as expected: 
Argument(s) are different! Wanted:
connection.sendObject(
    org.specs2.matcher.StringBaseMatchers$$anon$2@537a7706
);
-> at my.VerifyWithContainSpec$$anonfun$2$$anonfun$apply$11$$anonfun$apply$13$$anonfun$apply$5.apply$mcV$sp(VerifyWithContainSpec.scala:48)
Actual invocation has different arguments:
connection.sendObject(
    "abc"
);
-> at my.VerifyWithContainSpec$Client.helloObject(VerifyWithContainSpec.scala:16)

	at org.specs2.matcher.MatchResultStackTrace$class.setStacktrace(Expectations.scala:57)
	at org.specs2.mutable.Specification.setStacktrace(Specification.scala:15)
	at org.specs2.matcher.ExpectationsCreation$class.checkFailure(Expectations.scala:37)
	at org.specs2.mutable.Specification.checkFailure(Specification.scala:15)
	at org.specs2.matcher.ThrownExpectationsCreation$$anon$1.check(ThrownExpectations.scala:37)
	at org.specs2.matcher.Expectable.applyMatcher(Expectable.scala:50)
	at org.specs2.matcher.ThrownExpectationsCreation$$anon$1.applyMatcher(ThrownExpectations.scala:36)
	at org.specs2.mock.mockito.CalledMatchers$Calls.was(CalledMatchers.scala:69)
	at my.VerifyWithContainSpec$$anonfun$2$$anonfun$apply$11$$anonfun$apply$13.apply(VerifyWithContainSpec.scala:48)
	at my.VerifyWithContainSpec$$anonfun$2$$anonfun$apply$11$$anonfun$apply$13.apply(VerifyWithContainSpec.scala:46)
	at org.specs2.matcher.MatchResult$$anon$12$$anonfun$asResult$1.apply(MatchResult.scala:310)
	at org.specs2.matcher.MatchResult$$anon$12$$anonfun$asResult$1.apply(MatchResult.scala:310)
	at org.specs2.execute.ResultExecution$class.execute(ResultExecution.scala:25)
	at org.specs2.execute.ResultExecution$.execute(ResultExecution.scala:120)
	at org.specs2.execute.Result$$anon$10.asResult(Result.scala:230)
	at org.specs2.execute.AsResult$.apply(AsResult.scala:25)
	at org.specs2.matcher.MatchResult$$anon$12.asResult(MatchResult.scala:310)
	at org.specs2.execute.AsResult$.apply(AsResult.scala:25)
	at org.specs2.main.CommandLineAsResult$$anon$1.asResult(CommandLineAsResult.scala:17)
	at org.specs2.main.CommandLineAsResult$$anonfun$apply$1.apply(CommandLineAsResult.scala:21)
	at org.specs2.main.CommandLineAsResult$$anonfun$apply$1.apply(CommandLineAsResult.scala:21)
	at org.specs2.specification.dsl.mutable.ExampleDsl1$BlockExample$$anonfun$$greater$greater$1.apply(ExampleDsl.scala:37)
	at org.specs2.specification.dsl.mutable.ExampleDsl1$BlockExample$$anonfun$$greater$greater$1.apply(ExampleDsl.scala:37)
	at org.specs2.specification.core.Execution$$anonfun$withEnv$1$$anonfun$apply$3.apply(Execution.scala:119)
	at org.specs2.execute.ResultExecution$class.execute(ResultExecution.scala:25)
	at org.specs2.execute.ResultExecution$.execute(ResultExecution.scala:120)
	at org.specs2.execute.Result$$anon$10.asResult(Result.scala:230)
	at org.specs2.execute.AsResult$.apply(AsResult.scala:25)
	at org.specs2.specification.core.Execution$$anonfun$withEnv$1.apply(Execution.scala:119)
	at org.specs2.specification.core.Execution$$anonfun$withEnv$1.apply(Execution.scala:119)
	at org.specs2.specification.core.Execution$$anonfun$execute$2$$anonfun$apply$2.apply(Execution.scala:69)
	at org.specs2.specification.core.Execution$$anonfun$execute$2$$anonfun$apply$2.apply(Execution.scala:69)
	at org.specs2.specification.core.Execution.setResult(Execution.scala:75)
	at org.specs2.specification.core.Execution$$anonfun$execute$2.apply(Execution.scala:69)
	at org.specs2.specification.core.Execution$$anonfun$execute$2.apply(Execution.scala:69)
	at scala.Option.fold(Option.scala:158)
	at org.specs2.specification.core.Execution.execute(Execution.scala:69)
	at org.specs2.specification.dsl.mutable.MutableFragmentBuilder$$anonfun$duplicateExecution$1$$anonfun$apply$3.apply(MutableFragmentBuilder.scala:117)
	at org.specs2.specification.dsl.mutable.MutableFragmentBuilder$$anonfun$duplicateExecution$1$$anonfun$apply$3.apply(MutableFragmentBuilder.scala:107)
	at scalaz.$bslash$div.fold(Either.scala:57)
	at org.specs2.specification.dsl.mutable.MutableFragmentBuilder$$anonfun$duplicateExecution$1.apply(MutableFragmentBuilder.scala:105)
	at org.specs2.specification.dsl.mutable.MutableFragmentBuilder$$anonfun$duplicateExecution$1.apply(MutableFragmentBuilder.scala:99)
	at org.specs2.specification.core.Execution$$anonfun$withEnv$1$$anonfun$apply$3.apply(Execution.scala:119)
	at org.specs2.execute.ResultExecution$class.execute(ResultExecution.scala:25)
	at org.specs2.execute.ResultExecution$.execute(ResultExecution.scala:120)
	at org.specs2.execute.Result$$anon$10.asResult(Result.scala:230)
	at org.specs2.execute.AsResult$.apply(AsResult.scala:25)
	at org.specs2.specification.core.Execution$$anonfun$withEnv$1.apply(Execution.scala:119)
	at org.specs2.specification.core.Execution$$anonfun$withEnv$1.apply(Execution.scala:119)
	at org.specs2.specification.core.Execution$$anonfun$execute$2$$anonfun$apply$2.apply(Execution.scala:69)
	at org.specs2.specification.core.Execution$$anonfun$execute$2$$anonfun$apply$2.apply(Execution.scala:69)
	at org.specs2.specification.core.Execution.setResult(Execution.scala:75)
	at org.specs2.specification.core.Execution$$anonfun$execute$2.apply(Execution.scala:69)
	at org.specs2.specification.core.Execution$$anonfun$execute$2.apply(Execution.scala:69)
	at scala.Option.fold(Option.scala:158)
	at org.specs2.specification.core.Execution.execute(Execution.scala:69)
	at org.specs2.specification.process.DefaultExecutor$$anonfun$executeFragment$1$$anonfun$apply$6.apply(Executor.scala:132)
	at org.specs2.specification.process.DefaultExecutor$$anonfun$executeFragment$1$$anonfun$apply$6.apply(Executor.scala:130)
	at org.specs2.specification.core.Fragment.updateExecution(Fragment.scala:44)
	at org.specs2.specification.process.DefaultExecutor$$anonfun$executeFragment$1.apply(Executor.scala:130)
	at org.specs2.specification.process.DefaultExecutor$$anonfun$executeFragment$1.apply(Executor.scala:129)
	at org.specs2.specification.process.DefaultExecutor$$anonfun$sequencedExecution$1.executedFragment$lzycompute$1(Executor.scala:104)
	at org.specs2.specification.process.DefaultExecutor$$anonfun$sequencedExecution$1.org$specs2$specification$process$DefaultExecutor$class$$anonfun$$executedFragment$1(Executor.scala:104)
	at org.specs2.specification.process.DefaultExecutor$$anonfun$sequencedExecution$1$$anonfun$4.apply(Executor.scala:110)
	at org.specs2.specification.process.DefaultExecutor$$anonfun$sequencedExecution$1$$anonfun$4.apply(Executor.scala:110)
	at scalaz.concurrent.Task$.Try(Task.scala:385)
	at org.specs2.data.Processes$$anonfun$start$1.apply(Processes.scala:96)
	at org.specs2.data.Processes$$anonfun$start$1.apply(Processes.scala:96)
	at scalaz.concurrent.Future$$anonfun$apply$15$$anon$3.call(Future.scala:367)
	at scalaz.concurrent.Future$$anonfun$apply$15$$anon$3.call(Future.scala:367)
	at java.util.concurrent.FutureTask$Sync.innerRun(FutureTask.java:303)
	at java.util.concurrent.FutureTask.run(FutureTask.java:138)
	at java.util.concurrent.ThreadPoolExecutor$Worker.runTask(ThreadPoolExecutor.java:895)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:918)
	at java.lang.Thread.run(Thread.java:695)

```

See this issue reported: https://youtrack.jetbrains.com/issue/SCL-8668

Verify the type of a param
--------------------------

Successful from SBT command line
```
$ ./sbt
> test-only my.VerifyIntTypesSpec
[info] Updating {file:/Users/twer/workspace/specs2-test/}specs2-test...
[info] Resolving jline#jline;2.12.1 ...
[info] Done updating.
[info] Compiling 3 Scala sources to /Users/twer/workspace/specs2-test/target/scala-2.11/test-classes...
[info] VerifyIntTypesSpec
[info]
[info] user should
[info]   + send 3 objects, but two ints only
[info]
[info] Total for specification VerifyIntTypesSpec
[info] Finished in 487 ms
[info] 1 example, 0 failure, 0 error
[info] Passed: Total 1, Failed 0, Errors 0, Passed 1
[success] Total time: 14 s, completed Apr 24, 2015 10:32:04 PM
```

Failed within IDEA:

```

The mock was not called as expected: 
Argument(s) are different! Wanted:
sender.send(
    org.specs2.matcher.AnyBaseMatchers$$anon$4@2f3acc52
);
-> at my.VerifyIntTypesSpec$$anonfun$1$$anonfun$apply$4$$anonfun$apply$1.apply$mcV$sp(VerifyIntTypesSpec.scala:26)
Actual invocation has different arguments:
sender.send(
    "hello"
);
-> at my.VerifyIntTypesSpec$User.hello(VerifyIntTypesSpec.scala:15)

java.lang.Exception: The mock was not called as expected: 
Argument(s) are different! Wanted:
sender.send(
    org.specs2.matcher.AnyBaseMatchers$$anon$4@2f3acc52
);
-> at my.VerifyIntTypesSpec$$anonfun$1$$anonfun$apply$4$$anonfun$apply$1.apply$mcV$sp(VerifyIntTypesSpec.scala:26)
Actual invocation has different arguments:
sender.send(
    "hello"
);
-> at my.VerifyIntTypesSpec$User.hello(VerifyIntTypesSpec.scala:15)

	at org.specs2.matcher.MatchResultStackTrace$class.setStacktrace(Expectations.scala:57)
	at org.specs2.mutable.Specification.setStacktrace(Specification.scala:15)
	at org.specs2.matcher.ExpectationsCreation$class.checkFailure(Expectations.scala:37)
	at org.specs2.mutable.Specification.checkFailure(Specification.scala:15)
	at org.specs2.matcher.ThrownExpectationsCreation$$anon$1.check(ThrownExpectations.scala:37)
	at org.specs2.matcher.Expectable.applyMatcher(Expectable.scala:50)
	at org.specs2.matcher.ThrownExpectationsCreation$$anon$1.applyMatcher(ThrownExpectations.scala:36)
	at org.specs2.mock.mockito.CalledMatchers$Calls.was(CalledMatchers.scala:69)
	at my.VerifyIntTypesSpec$$anonfun$1$$anonfun$apply$4.apply(VerifyIntTypesSpec.scala:26)
	at my.VerifyIntTypesSpec$$anonfun$1$$anonfun$apply$4.apply(VerifyIntTypesSpec.scala:22)
	at org.specs2.matcher.MatchResult$$anon$12$$anonfun$asResult$1.apply(MatchResult.scala:310)
	at org.specs2.matcher.MatchResult$$anon$12$$anonfun$asResult$1.apply(MatchResult.scala:310)
	at org.specs2.execute.ResultExecution$class.execute(ResultExecution.scala:25)
	at org.specs2.execute.ResultExecution$.execute(ResultExecution.scala:120)
	at org.specs2.execute.Result$$anon$10.asResult(Result.scala:230)
	at org.specs2.execute.AsResult$.apply(AsResult.scala:25)
	at org.specs2.matcher.MatchResult$$anon$12.asResult(MatchResult.scala:310)
	at org.specs2.execute.AsResult$.apply(AsResult.scala:25)
	at org.specs2.main.CommandLineAsResult$$anon$1.asResult(CommandLineAsResult.scala:17)
	at org.specs2.main.CommandLineAsResult$$anonfun$apply$1.apply(CommandLineAsResult.scala:21)
	at org.specs2.main.CommandLineAsResult$$anonfun$apply$1.apply(CommandLineAsResult.scala:21)
	at org.specs2.specification.dsl.mutable.ExampleDsl1$BlockExample$$anonfun$$greater$greater$1.apply(ExampleDsl.scala:37)
	at org.specs2.specification.dsl.mutable.ExampleDsl1$BlockExample$$anonfun$$greater$greater$1.apply(ExampleDsl.scala:37)
	at org.specs2.specification.core.Execution$$anonfun$withEnv$1$$anonfun$apply$3.apply(Execution.scala:119)
	at org.specs2.execute.ResultExecution$class.execute(ResultExecution.scala:25)
	at org.specs2.execute.ResultExecution$.execute(ResultExecution.scala:120)
	at org.specs2.execute.Result$$anon$10.asResult(Result.scala:230)
	at org.specs2.execute.AsResult$.apply(AsResult.scala:25)
	at org.specs2.specification.core.Execution$$anonfun$withEnv$1.apply(Execution.scala:119)
	at org.specs2.specification.core.Execution$$anonfun$withEnv$1.apply(Execution.scala:119)
	at org.specs2.specification.core.Execution$$anonfun$execute$2$$anonfun$apply$2.apply(Execution.scala:69)
	at org.specs2.specification.core.Execution$$anonfun$execute$2$$anonfun$apply$2.apply(Execution.scala:69)
	at org.specs2.specification.core.Execution.setResult(Execution.scala:75)
	at org.specs2.specification.core.Execution$$anonfun$execute$2.apply(Execution.scala:69)
	at org.specs2.specification.core.Execution$$anonfun$execute$2.apply(Execution.scala:69)
	at scala.Option.fold(Option.scala:158)
	at org.specs2.specification.core.Execution.execute(Execution.scala:69)
	at org.specs2.specification.dsl.mutable.MutableFragmentBuilder$$anonfun$duplicateExecution$1$$anonfun$apply$3.apply(MutableFragmentBuilder.scala:117)
	at org.specs2.specification.dsl.mutable.MutableFragmentBuilder$$anonfun$duplicateExecution$1$$anonfun$apply$3.apply(MutableFragmentBuilder.scala:107)
	at scalaz.$bslash$div.fold(Either.scala:57)
	at org.specs2.specification.dsl.mutable.MutableFragmentBuilder$$anonfun$duplicateExecution$1.apply(MutableFragmentBuilder.scala:105)
	at org.specs2.specification.dsl.mutable.MutableFragmentBuilder$$anonfun$duplicateExecution$1.apply(MutableFragmentBuilder.scala:99)
	at org.specs2.specification.core.Execution$$anonfun$withEnv$1$$anonfun$apply$3.apply(Execution.scala:119)
	at org.specs2.execute.ResultExecution$class.execute(ResultExecution.scala:25)
	at org.specs2.execute.ResultExecution$.execute(ResultExecution.scala:120)
	at org.specs2.execute.Result$$anon$10.asResult(Result.scala:230)
	at org.specs2.execute.AsResult$.apply(AsResult.scala:25)
	at org.specs2.specification.core.Execution$$anonfun$withEnv$1.apply(Execution.scala:119)
	at org.specs2.specification.core.Execution$$anonfun$withEnv$1.apply(Execution.scala:119)
	at org.specs2.specification.core.Execution$$anonfun$execute$2$$anonfun$apply$2.apply(Execution.scala:69)
	at org.specs2.specification.core.Execution$$anonfun$execute$2$$anonfun$apply$2.apply(Execution.scala:69)
	at org.specs2.specification.core.Execution.setResult(Execution.scala:75)
	at org.specs2.specification.core.Execution$$anonfun$execute$2.apply(Execution.scala:69)
	at org.specs2.specification.core.Execution$$anonfun$execute$2.apply(Execution.scala:69)
	at scala.Option.fold(Option.scala:158)
	at org.specs2.specification.core.Execution.execute(Execution.scala:69)
	at org.specs2.specification.process.DefaultExecutor$$anonfun$executeFragment$1$$anonfun$apply$6.apply(Executor.scala:132)
	at org.specs2.specification.process.DefaultExecutor$$anonfun$executeFragment$1$$anonfun$apply$6.apply(Executor.scala:130)
	at org.specs2.specification.core.Fragment.updateExecution(Fragment.scala:44)
	at org.specs2.specification.process.DefaultExecutor$$anonfun$executeFragment$1.apply(Executor.scala:130)
	at org.specs2.specification.process.DefaultExecutor$$anonfun$executeFragment$1.apply(Executor.scala:129)
	at org.specs2.specification.process.DefaultExecutor$$anonfun$sequencedExecution$1.executedFragment$lzycompute$1(Executor.scala:104)
	at org.specs2.specification.process.DefaultExecutor$$anonfun$sequencedExecution$1.org$specs2$specification$process$DefaultExecutor$class$$anonfun$$executedFragment$1(Executor.scala:104)
	at org.specs2.specification.process.DefaultExecutor$$anonfun$sequencedExecution$1$$anonfun$4.apply(Executor.scala:110)
	at org.specs2.specification.process.DefaultExecutor$$anonfun$sequencedExecution$1$$anonfun$4.apply(Executor.scala:110)
	at scalaz.concurrent.Task$.Try(Task.scala:385)
	at org.specs2.data.Processes$$anonfun$start$1.apply(Processes.scala:96)
	at org.specs2.data.Processes$$anonfun$start$1.apply(Processes.scala:96)
	at scalaz.concurrent.Future$$anonfun$apply$15$$anon$3.call(Future.scala:367)
	at scalaz.concurrent.Future$$anonfun$apply$15$$anon$3.call(Future.scala:367)
	at java.util.concurrent.FutureTask$Sync.innerRun(FutureTask.java:303)
	at java.util.concurrent.FutureTask.run(FutureTask.java:138)
	at java.util.concurrent.ThreadPoolExecutor$Worker.runTask(ThreadPoolExecutor.java:895)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:918)
	at java.lang.Thread.run(Thread.java:695)


```
