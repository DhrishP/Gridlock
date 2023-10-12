"use client";
import React, { useEffect, useState } from "react";
import axios from "axios";
import { redirect } from "next/navigation";

type dataschema = {
  id: string;
  username: string;
  red_score: number;
  green_score: number;
  date: string;
};
const StatsPage = () => {
  const [data, setdata] = useState([] as dataschema[]);
  useEffect(() => {
    const username = localStorage.getItem("username");
    const secret = localStorage.getItem("secret");
    if (!username || !secret) redirect("/");
  }, []);
  useEffect(() => {
    const getdata = async () => {
      const data = await axios.get("api/scores");
      setdata(data.data);
    };
    getdata();
  }, []);
  return (
    <div>
      {data.map((user) => (
        <>
          <div>
            {user.username}
            {user.red_score}
            {user.green_score}
          </div>
        </>
      ))}
    </div>
  );
};

export default StatsPage;
