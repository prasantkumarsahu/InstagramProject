# Intagram Clone Project
This is a API project is a clone of `Instagram`.

![Spring Boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot "Spring Boot") ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white "Java") ![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white "Postman") ![Google Chrome](https://img.shields.io/badge/Google%20Chrome-4285F4?style=for-the-badge&logo=GoogleChrome&logoColor=white "Google Chrome")

## Frameworks and Languages
![Java v17](https://img.shields.io/badge/Java-v17-green "Java 17") ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-v3.0.6-brightgreen "Spring Boot v3.0.6")

---
## Browser / Tools
![Google Chrome](https://img.shields.io/badge/Google%20Chrome-v112.0.5615.138-yellow "Google Chrome") ![Postman](https://img.shields.io/badge/Postman-v10.13.0-orange "Postman")
---

## Model
- ### User
    - ```java
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long userId;
      ```
    - ```java
      @Column(nullable = false)
      @NotEmpty
      private String firstName;
      ```
    - ```java
      @Column(nullable = false)
      @NotEmpty
      private String lastName;
      ```
    - ```java
      @Column(nullable = false, unique = true)
      @NotEmpty
      private String instagramName;
      ```
    - ```java
      private String instagramBio;
      ```
    - ```java
      @Column(nullable = false)
      @NotEmpty
      private String password;
      ```
    - ```java
      @Column(nullable = false)
      @Past
      @NotNull
      private LocalDate dOB;
      ```
    - ```java
      @Column(unique = true , nullable = false)
      @Email
      @NotBlank
      private String email;
      ```
    - ```java
      @Column(nullable = false)
      @Pattern(regexp = "\\d{2}-\\d{10}", message = "Phone number should be in the format XX-XXXXXXXXXX")
      private String phoneNumber;
      ```
    - ```java
      @JsonProperty(access = JsonProperty.Access.READ_ONLY)
      private boolean isBlueTicked;
      ```
- ### Admin
    - ```java
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long adminId;
      ```
    - ```java
      @Column(nullable = false)
      @NotEmpty
      private String firstName;
      ```
    - ```java
      @Column(nullable = false)
      @NotEmpty
      private String lastName;
      ```
    - ```java
      @Column(unique = true , nullable = false)
      @Email
      @NotBlank
      private String email;
      ```
- ### Post
    - ```java
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Integer postId;
      ```
    - ```java
      @Column(nullable = false)
      private LocalDateTime createdDate;
      ```
    - ```java
      @Column(nullable = false)
      @NotEmpty
      private String postData;
      ```
    - ```java
      private String postCaption;
      ```
    - ```java
      private String location;
      ```
    - ```java
      @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(nullable = false , name = "fk_user_ID")
      private User user;
      ```
- ### AuthenticationToken
    - ```java
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long tokenId;
      ```
    - ```java
      private String token;
      ```
    - ```java
      private LocalDate tokenCreationDate;
      ```
    - ```java
      @OneToOne
      @JoinColumn(nullable = false , name = "fk_user_ID")
      private User user;
      ```
- ### InstagramComment
    - ```java
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long commentId;
      ```
    - ```java
      private String commentBody;
      ```
    - ```java
      @ManyToOne
      @JoinColumn(nullable = false , name = "fk_post_ID")
      private Post post;
      ```
    - ```java
      @ManyToOne
      @JoinColumn(nullable = false , name = "fk_user_ID")
      private User user;
      ```
- ### InstagramFollower
    - ```java
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long followerTableId;
      ```
    - ```java
      @OneToOne
      private User user;
      ```
    - ```java
      @OneToOne
      private User follower;
      ```
- ### InstagramFollowing
    - ```java
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long followingTableId;
      ```
    - ```java
      @OneToOne
      private User user;
      ```
    - ```java
      @OneToOne
      private User following;
      ```
- ### PostLike
    - ```java
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long likeId;
      ```
    - ```java
      @ManyToOne
      @JoinColumn(nullable = false , name = "fk_post_ID")
      private Post post;
      ```
    - ```java
      @ManyToOne
      @JoinColumn(nullable = false , name = "fk_user_ID")
      private User user;
      ```
## Dataflow
- ### End Points / Controllers
  - #### _User_
    `@RequestMapping("user")`
    - `@PostMapping("/signup")`
    - `@PostMapping("/signin")`
    - `@DeleteMapping("/signout")`
    - `@PutMapping()`
    - `@PostMapping("/follow/{myId}/{otherId}")`
    - `@PostMapping("/like")`
  - #### _Admin_
    `@RequestMapping("admin")`
    - `@PutMapping("user/{id}/{blueTick}")`
  - #### _Post_
    `@RequestMapping("post")`
    - `@PostMapping()`
    - `@GetMapping()`
    - `@GetMapping("/{postId}/likeCount")`
  - #### _Comment_
    `@RequestMapping("comment")`
    - `@PostMapping()`
- ### Services
  - #### _User_
    ```java
    public SignUpOutput signUp(User signUpDto)
    ```
    ```java
    private String encryptPassword(String userPassword) throws NoSuchAlgorithmException
    ```
    ```java
    public SignInOutput signIn(SignInInput signInDto)
    ```
    ```java
    public void updateUser(User user , String token)
    ```
    ```java
    @Transactional
    public String followUser(Long myId, Long otherId)
    ```
    ```java
    public String toggleBlueTick(Long id, boolean blueTick)
    ```
    ```java
    public void like(PostLike postLike)
    ```
  - #### _Admin_
    ```java
    public String toggleBlueTick(Long id, boolean blueTick)
    ```
  - #### _Post_
    ```java
    public void addPost(Post post)
    ```
    ```java
    public List<Post> getAllPosts(String token)
    ```
    ```java
    public long getLikes(Long postId)
    ```
  - #### _Comment_
    ```java
    public String addComment(InstagramComment comment)
    ```
  - #### _Authentication_
    ```java
    public void saveToken(AuthenticationToken token)
    ```
    ```java
    public boolean authenticate(String email, String token)
    ```
    ```java
    public void deleteToken(String token)
    ```
    ```java
    public User findUserByToken(String token)
    ```
  - #### _Follower_
    ```java
    public void saveFollower(User myUser, User otherUser)
    ```
  - #### _Following_
    ```java
    public void saveFollowing(User myUser, User otherUser)
    ```
  - #### _Like_
    ```java
    public void like(PostLike postLike)
    ```
    ```java
    public long getLikes(Long postId)
    ```
- ### Repository
    - _User_
        ```java
        @Repository
        public interface IUserRepo extends JpaRepository<User, Long> {

          User findFirstByEmail(String email);

          User findByUserId(Long id);
        }
        ```
    - _Admin_
        ```java
        public interface IAdminRepo extends JpaRepository<Admin, Long> {
        }
        ```
    - _Post_
        ```java
        @Repository
        public interface IPostRepo extends JpaRepository<Post, Integer> {
          List<Post> findByUser(User user);
        }
        ```
    - _AuthenticationToken_
        ```java
        @Repository
        public interface ITokenRepo extends JpaRepository<AuthenticationToken , Long> {
          AuthenticationToken findFirstByToken(String token);
        }
        ```
    - _Comment_
        ```java
        public interface ICommentRepo extends JpaRepository<InstagramComment, Long> {
        }
        ```
    - _Follower_
        ```java
        public interface IFollowerRepo extends JpaRepository<InstagramFollower, Long> {
        }
        ```
    - _Following_
        ```java
        public interface IFollowingRepo extends JpaRepository<InstagramFollowing, Long> {
          Long countByUser_userId(long userId);
        }
        ```
    - _Like_
        ```java
        public interface ILikeRepo extends JpaRepository<PostLike, Long> {
          long countByPost_PostId(Long postId);
        }
        ```
- ### Database
    I have used `MySQL` database in this project. And used `SpringDataJPA`.
---
## Datastructures
- `ArrayList<>`
---
## Summary
This API is a `Spring Boot` project that is about `Instagram` Clone. In this project request is sent from the client on HTTP in JSON body or from path variable and stored in object then response is sent back from the server by JSON format to the client.

