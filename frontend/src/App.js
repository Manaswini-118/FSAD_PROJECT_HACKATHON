import { useState } from "react";
import axios from "axios";
import "./App.css";

export default function App() {

  const [form, setForm] = useState({
    salaryIncome: "",
    otherIncome: "",
    deductions: ""
  });

  const [result, setResult] = useState(null);

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const calculateTax = async () => {
    try {
      const res = await axios.post(
        "http://localhost:8081/api/tax/calculate",
        form
      );
      setResult(res.data);
    } catch (error) {
      console.error(error);
      alert("Backend not running!");
    }
  };

  return (
    <div className="app">

      {/* BACKGROUND BLOBS */}
      <div className="blob blob1"></div>
      <div className="blob blob2"></div>

      {/* HERO */}
      <div className="hero">
        <h1>Tax Intelligence</h1>
        <p>Design meets finance. Understand your taxes visually.</p>
      </div>

      {/* MAIN PANEL */}
      <div className="panel">

        {/* INPUT CARD */}
        <div className="card">
          <h2>Input</h2>

          <input
            name="salaryIncome"
            placeholder="Salary Income"
            onChange={handleChange}
          />
          <input
            name="otherIncome"
            placeholder="Other Income"
            onChange={handleChange}
          />
          <input
            name="deductions"
            placeholder="Deductions"
            onChange={handleChange}
          />

          <button onClick={calculateTax}>
            Generate Insight
          </button>
        </div>

        {/* RESULT CARD */}
        <div className="card">
          <h2>Insights</h2>

          {result ? (
            <>
              {/* TOP STATS */}
              <div className="stats">
                <div>
                  <span>Total</span>
                  <h3>₹{result.totalIncome}</h3>
                </div>
                <div>
                  <span>Taxable</span>
                  <h3>₹{result.taxableIncome}</h3>
                </div>
                <div>
                  <span>Best</span>
                  <h3>{result.recommendedRegime}</h3>
                </div>
              </div>

              {/* TAX COMPARISON */}
              <div className="bars">

                <div>
                  <p>Old Regime</p>
                  <div className="bar-bg">
                    <div
                      className="bar old"
                      style={{
                        width: `${result.oldRegimeTax / 5000}px`
                      }}
                    ></div>
                  </div>
                  ₹{result.oldRegimeTax}
                </div>

                <div>
                  <p>New Regime</p>
                  <div className="bar-bg">
                    <div
                      className="bar new"
                      style={{
                        width: `${result.newRegimeTax / 5000}px`
                      }}
                    ></div>
                  </div>
                  ₹{result.newRegimeTax}
                </div>

              </div>

              {/* FINAL INSIGHT */}
              <div className="insight">
                💡 You save ₹
                {Math.abs(result.oldRegimeTax - result.newRegimeTax)} by choosing{" "}
                <b>{result.recommendedRegime}</b>
              </div>
            </>
          ) : (
            <p className="empty">No insights yet</p>
          )}

        </div>

      </div>
    </div>
  );
}