# 사용할 Java 버전 지정
FROM amazoncorretto:17

# 작업 디렉토리 설정
WORKDIR /app

# 애플리케이션 빌드 파일과 필요한 모든 파일 복사
COPY build/libs/*.jar app.jar

# 애플리케이션 실행
CMD ["java", "-jar", "app.jar"]
