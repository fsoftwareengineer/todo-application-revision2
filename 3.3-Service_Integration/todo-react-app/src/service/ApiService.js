import { API_BASE_URL } from "../api-config";

export function call(api, method, request) {
  let options = {
    headers: new Headers({
      "Content-Type": "application/json",
    }),
    url: API_BASE_URL + api,
    method: method,
  };
  if (request) {
    // GET method
    options.body = JSON.stringify(request);
  }
  return fetch(options.url, options).then((response) =>
    response.json().then((json) => {
      if (!response.ok) {
        // response.ok가 true이면 정상적인 응답을 받은것, 아니면 에러 응답을 받은것.
        return Promise.reject(json);
      }
      return json;
    })
  );
}
