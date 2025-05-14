
# Java 17 기반 이미지
FROM eclipse-temurin:17-jdk

# 작업 디렉토리 설정
WORKDIR /app

# JAR 복사
COPY build/libs/expert-0.0.1-SNAPSHOT.jar app.jar

# 앱 실행
ENTRYPOINT ["java", "-jar", "app.jar"]