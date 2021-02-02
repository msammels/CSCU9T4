### CSCU9T4

The code within this repository is designed and developed in line with the
practicals for the second year course at the University of Stirling.

## Prerequisites
You need to have the following installed:

- The Java SDK
  - This can be either Oracle or OpenJDK of at least version 8.0
- A suitable IDE
  - The files in this repository where created using
  [IntelliJ IDEA Ultimate](https://www.jetbrains.com/idea/), but any suitable
  editor will work.

## Compiling
As stated earlier, the code was created using my favourite editor, but I have
removed all of the files that the editor generated, leaving just the base
files.

The code here **does** use external libraries. It uses the following:

    JUnit 5.0

The code here will also be using elements of Maven, so please be sure to
remember this if you decide to use this code. There should be no issues,
as long as you remember to import JUnit 5.0 into your editor.
This varies from editor to editor, and as such I am not going to be able to
comment on any one specific editor.

## Folder Layout
You will notice that this does not use the standard folder structure, as
normally found:

    /src/com/msammels/project/main/src/File.Java
    /src/com/msammels/project/test/src/File.java

Instead we are using a slightly different layout:

    /src/main/java/com/stir/cscu9t4/practicalX/File.java

I am unsure if this is the new standard, or just the way that my editor
decided to organise packages vs projects.

You should be able to move things into whatever folder structure you feel
most appropriate and things should still work OK. If you are using the same
editor as myself you will need to make sure that each folder is located
within it's own module (so to avoid conflicts) or make each one a separate
project. I cannot comment on other editors.

```
Michael Sammels
```
