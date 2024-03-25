# Spring AI in Action Examples

This repository holds example code from _Spring AI in Action_, by Craig Walls.

The repository also holds a project catalog for the [Spring CLI](https://spring.io/projects/spring-cli). Therefore, you can either clone the repository in its entirety or you can use the Spring CLI to create Spring Boot projects based on the projects contained herein.

If you choose to use the Spring CLI, you'll need to add this repository's project catalog. Use the `spring project-catalog add` command like this:

```
% spring project-catalog add spring-ai-examples https://github.com/habuma/spring-ai-in-action-examples
```

Once you've added the project catalog, you should see these projects when getting a list of projects:

```
% spring project list
```

Then, you can use `spring boot new` to create a new project based on any of the projects in this repository. For example, to create a project based on chapter 1's example:

```
% spring boot new spring-ai-ask ch01-ask com.example.ai
```

Happy AI'ing!
