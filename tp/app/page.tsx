"use client";
import LoginForm from "@/components/loginform";
import { redirect } from "next/navigation";
import { useEffect } from "react";

export default function Home() {
  useEffect(() => {
    // Perform localStorage action
    const username = localStorage.getItem("username")
    const secret = localStorage.getItem("secret");
    if (username && secret) redirect("/statspage");
    localStorage.setItem("username", JSON.stringify([]))
    localStorage.setItem("secret", JSON.stringify([]))
  }, []);
  return (
    <>
      <LoginForm />
    </>
  );
}
