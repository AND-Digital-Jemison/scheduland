import React from "react";
import { useQuery } from "@tanstack/react-query";

const getDogData = async () => {
  return await (
    await fetch(
      `http://scheduland-app-env.eba-mynxvqr3.eu-west-2.elasticbeanstalk.com/dog/`
    )
  ).json();
};

export default function DogImage() {
  const { data, isLoading, isError, error } = useQuery({
    queryKey: ["dogImageData"],
    queryFn: getDogData,
  });

  if (isLoading) {
    return <span>Loading...</span>;
  }

  if (isError && error instanceof Error) {
    return <span>Error: {error.message}</span>;
  }

  return <div>{JSON.stringify(data)}</div>;
}
