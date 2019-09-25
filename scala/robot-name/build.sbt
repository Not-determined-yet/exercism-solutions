scalaVersion := "2.12.8"

scalacOptions ++= Seq("-deprecation")

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

testOptions in Test += Tests.Argument("-oDF")
