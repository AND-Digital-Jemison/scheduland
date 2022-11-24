import { render, screen, fireEvent } from "@testing-library/react";
import DogImage from "./DogImage";
describe("DogImage", () => {
  it("Should display a random image of a dog", () => {
    render(<DogImage />);
    const text = screen.getByText("DogImage");
    expect(text).toBeTruthy();
  });
});
