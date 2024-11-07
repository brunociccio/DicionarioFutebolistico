docker build -t dicionariofutebolistico .

docker run -d \
  -p 8080:8080 \
  -e OPENAI_API_KEY=your-openai-api-key \
  -e DATABASE_URL=jdbc:postgresql://localhost:5432/dicionariofut \
  -e DATABASE_USERNAME=your_db_username \
  -e DATABASE_PASSWORD=your_db_password \
  --name dicionariofut-container \
  dicionariofutebolistico
